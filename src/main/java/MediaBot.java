import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import util.MyUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Comparator;
import java.util.List;

public class MediaBot extends TelegramLongPollingBot {

    private static short successfully = 0;
    private static short failed = 0;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasPhoto()) {
            Message message = update.getMessage();
            List<PhotoSize> photos = message.getPhoto();
            PhotoSize largestPhoto = photos.stream()
                    .max(Comparator.comparingInt(PhotoSize::getFileSize))
                    .orElse(photos.get(photos.size() - 1));
            String captureName = null;
            try {
                File file = execute(new GetFile(largestPhoto.getFileId()));
                int index = file.getFilePath().lastIndexOf(".");
                String fileExtension = file.getFilePath().substring(index);
                String[] captions = message.getCaption().trim().split("#");
                captureName = captions[0].trim() + fileExtension;
                URL url = new URL("https://api.telegram.org/file/bot" + getBotToken() + "/" + file.getFilePath());
                ReadableByteChannel rbc = Channels.newChannel(url.openStream());
                String path = MyUtil.getPath(message.getCaption());
                FileOutputStream fos = new FileOutputStream(path + captureName);
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                fos.write(url.openConnection().getInputStream().readAllBytes());
                successfully++;
                System.out.println("File downloaded successfully : " + captureName + ", count : " + successfully
                        + ", path : " + path);
                fos.close();
                rbc.close();
            } catch (TelegramApiException | IOException e) {
                failed++;
                System.out.println("Exception occurred when downloading file : " + captureName + ", count : " + failed
                        + ", path : " + MyUtil.getPath(message.getCaption()));
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "FG96Bot";
    }

    @Override
    public String getBotToken() {
        return "6149811834:AAHVx9TgA1aiGq6VPspFuaCAK59_f4BE4es";
    }

}
