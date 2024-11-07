import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    static String path2file;

    public static void main(String[] args) {
        path2file = "F:\\Users\\User\\Documents\\JavaProjects\\TelegramParser\\newjson\\result.json";

        Gson log = new Gson();

        Chat chat = null;

        try (FileReader reader = new FileReader(path2file)) {
            // Parse JSON file into a Person object
            chat = log.fromJson(reader, Chat.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert chat != null;
        System.out.println(chat.messages.size() + " messages parsed. Starting GUI");

        new Parser(chat);
    }
}
