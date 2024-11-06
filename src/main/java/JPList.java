import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;

public class JPList extends JPanel {
    private final List<GUIMessage> messages;
    private int DisplayPanels;
    private final Parser parser;

    JPList(List<Message> messageList, Parser parser) {
        this.parser = parser;

        messages = new ArrayList<>();

        DisplayPanels = messageList.size();

        DisplayPanels = 1000;

        this.setLayout(new GridLayout(DisplayPanels, 1, 8, 8));

        for (Message m : messageList) {
            messages.add(new GUIMessage(m));
        }

        for (int i = 0; i < DisplayPanels; i++){
            add(messages.get(i));
        }
    }
}
