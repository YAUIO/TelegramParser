import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JPList extends JPanel {
    public final List<GUIMessage> messages;

    JPList(List<Message> messageList, Parser parser) {
        messages = new ArrayList<>();

        int DisplayPanels = messageList.size();

        this.setLayout(new GridLayout(DisplayPanels, 1, 8, 8));

        for (Message m : messageList) {
            messages.add(new GUIMessage(m, parser, this));
        }

        for (int i = 0; i < DisplayPanels; i++){
            add(messages.get(i));
        }
    }
}
