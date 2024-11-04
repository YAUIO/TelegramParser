import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Gson log = new Gson();

        Chat chat = null;

        try (FileReader reader = new FileReader("F:\\Users\\User\\Documents\\JavaProjects\\TelegramParser\\result.json")) {
            // Parse JSON file into a Person object
            chat = log.fromJson(reader, Chat.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert chat != null;
        System.out.println(chat.messages.size());

        Parser gui = new Parser(chat);
    }
}
