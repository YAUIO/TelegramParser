import java.util.List;

public class Message {
    int id;
    String type;
    String date;
    String date_unixtime;
    String actor;
    String actor_id;
    String action;
    String inviter;
    String from;
    String from_id;
    String forwarded_from;
    Integer reply_to_message_id;
    private Object text;
    List<TextEntity> text_entities;
    List<Reaction> reactions;
    ContactInformation contact_information;
    String photo;
    String file;
    String file_name;
    String media_type;
    String mime_type;
    int duration_seconds;
    int width;
    int height;


    public String getTextAsString() {
        if (text instanceof String) {
            return (String) text;
        } else if (text instanceof List) {
            return text.toString(); // Join array elements if it's a List
        }
        return null; // Or handle as appropriate
    }

    @Override
    public String toString() {
        return "test";
    }
}
