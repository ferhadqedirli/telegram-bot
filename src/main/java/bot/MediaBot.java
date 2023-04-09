package bot;

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
import java.util.Objects;

public class MediaBot extends TelegramLongPollingBot {

    private static short count = 0;

    @Override
    public void onUpdateReceived(Update update) {
        boolean isDocument = false;
        if (update.hasMessage() && (update.getMessage().hasPhoto() || update.getMessage().hasDocument())) {
            PhotoSize largestPhoto;
            String fileId = null;
            Document document = null;
            Message message = update.getMessage();
            if (update.getMessage().hasDocument()) {
                isDocument = true;
                document = update.getMessage().getDocument();
                if (document.getMimeType().startsWith("image")) {
                    fileId = document.getFileId();
                }
            } else {
                List<PhotoSize> photos = message.getPhoto();
                largestPhoto = photos.stream()
                        .max(Comparator.comparingInt(PhotoSize::getFileSize))
                        .orElse(photos.get(photos.size() - 1));
                fileId = largestPhoto.getFileId();
            }
            String captureName = null;
            String path = null;
            try {
                File file = execute(new GetFile(Objects.requireNonNull(fileId)));
                int index = file.getFilePath().lastIndexOf(".");
                String fileExtension = file.getFilePath().substring(index);
                if (isDocument) {
                    captureName = document.getFileName().trim().substring(0, index + 1) + fileExtension;
                    path = "D:\\PRO STUDIO\\";
                } else {
                    String[] captions = message.getCaption().trim().split("#");
                    captureName = captions[0].trim().split("[ \n]")[0].trim() + fileExtension;
                    path = MyUtil.getPath(message.getCaption());
                }
                URL url = new URL("https://api.telegram.org/file/bot" + getBotToken() + "/" + file.getFilePath());
                ReadableByteChannel rbc = Channels.newChannel(url.openStream());
                FileOutputStream fos = new FileOutputStream(path + captureName);
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                fos.write(url.openConnection().getInputStream().readAllBytes());
                count++;
                System.out.println("File downloaded successfully : " + captureName + ", count : " + count
                        + ", path : " + path);
                fos.close();
                rbc.close();
            } catch (TelegramApiException | IOException e) {
                count++;
                System.out.println("Exception occurred when downloading file : " + captureName + ", count : " + count
                        + ", path : " + path);
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
