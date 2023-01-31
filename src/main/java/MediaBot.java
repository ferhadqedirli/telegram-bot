import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Comparator;
import java.util.List;

public class MediaBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        if (update.hasMessage() && update.getMessage().hasPhoto()) {
            Message message = update.getMessage();
//            String fileId = message.getPhoto().get(0).getFileId();
            String captureName = message.getCaption().trim().substring(0, 21) + ".jpeg";
            List<PhotoSize> photos = message.getPhoto();
            PhotoSize largestPhoto = photos.stream()
                    .max(Comparator.comparingInt(PhotoSize::getFileSize))
                    .orElse(photos.get(photos.size() - 1));
            try {
//                Document document = message.getDocument();
                File file = execute(new GetFile(largestPhoto.getFileId()));
                System.out.println(file.getFileSize());
                URL url = new URL("https://api.telegram.org/file/bot" + getBotToken() + "/" + file.getFilePath());
                ReadableByteChannel rbc = Channels.newChannel(url.openStream());
                FileOutputStream fos = new FileOutputStream("D:\\img\\" + captureName);
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                fos.write(url.openConnection().getInputStream().readAllBytes());
                fos.close();
                rbc.close();
            } catch (TelegramApiException | IOException e) {
                e.printStackTrace();
            }
//            sendMessage(message.getChatId().toString(), "Image saved as " + captureName);
        }
    }

    private void sendMessage(String chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
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
