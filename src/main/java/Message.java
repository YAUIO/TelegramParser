import java.util.List;

public class Message {
    private int id;
    private String type;
    private String date;
    private String date_unixtime;
    private String actor;
    private String actor_id;
    private String action;
    private String inviter;
    private String from;
    private String from_id;
    private Object text;
    private List<TextEntity> text_entities;
    private List<Reaction> reactions;
    private String file;
    private String file_name;
    private String media_type;
    private String mime_type;
    private int duration_seconds;
    private int width;
    private int height;


    public String getTextAsString() {
        if (text instanceof String) {
            return (String) text;
        } else if (text instanceof List) {
            return String.join(", ", (List<String>) text); // Join array elements if it's a List
        }
        return null; // Or handle as appropriate
    }
}
