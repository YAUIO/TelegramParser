import javax.swing.*;
import java.awt.*;

public class GUIMessage extends JPanel {
    GUIMessage(Message m){
        add(new TextArea(m.getTextAsString()));
    }
}
