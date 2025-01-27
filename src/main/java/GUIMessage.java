import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GUIMessage extends JPanel {
    GUIMessage(Message m, Parser p, JPList list) {
        setSize(new Dimension(720, 160));
        setPreferredSize(new Dimension(720, 160));
        setLayout(new BorderLayout());

        String s = m.getTextAsString();

        ArrayList<Component> media = null;

        if (m.text_entities != null && !m.text_entities.isEmpty()) {
            s = "";
            for (TextEntity t : m.text_entities) {
                s += t.text + "\n";
                if (t.document_id != null && !t.document_id.isEmpty()) {
                    if (media == null) {
                        media = new ArrayList<>();
                    }
                    media.add(new Image(t.document_id));
                }
            }
        }

        if (m.contact_information != null && !m.contact_information.isEmpty()){
            s += m.contact_information.toString();
        }

        if (m.photo != null && !m.photo.isEmpty()) {
            if (media == null) {
                media = new ArrayList<>();
            }
            media.add(new Image(m.photo));
        }

        if (m.file != null && !m.file.isEmpty()) {
            if (m.media_type != null) {
                if (m.media_type.equals("sticker") || m.media_type.equals("image")) {
                    if (media == null) {
                        media = new ArrayList<>();
                    }
                    media.add(new Image(m.file));
                } else if (m.media_type.equals("animation") || m.media_type.equals("video_message")) {
                    if (media == null) {
                        media = new ArrayList<>();
                    }
                    media.add(new Video(m.file,p));
                }
            }

        }

        int len = s.length();
        int split = 400;

        while (len > split) {
            s = s.substring(0, split) + "\n" + s.substring(split);
            len -= split;
        }

        JTextArea text = new JTextArea();
        text.setEditable(false);
        text.setText(s);

        JTextArea info = new JTextArea();
        info.setSize(100, getHeight());
        info.setPreferredSize(new Dimension(200, getHeight()));
        info.setEditable(false);

        String infoS = "ID: " + m.id + "\nFrom: " + m.from_id + "\nName: " + m.from + "\nDate: " + m.date;

        if (m.reply_to_message_id != null && m.reply_to_message_id >= p.log.messages.getFirst().id) {
            infoS += "\n\nReply: " + m.reply_to_message_id;

            info.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        p.goTo(m.reply_to_message_id);
                    }
                }
            });
        }

        if (m.forwarded_from != null && !m.forwarded_from.isEmpty()){
            if (m.reply_to_message_id == null || m.reply_to_message_id < p.log.messages.getFirst().id) {
                infoS += "\n";
            }

            infoS += "\nForwarded: " + m.forwarded_from;
        }

        info.setText(infoS);

        add(text, BorderLayout.CENTER);
        add(info, BorderLayout.WEST);

        if (media != null && !media.isEmpty()) {
            for (Component i : media) {
                add(i, BorderLayout.EAST);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        g.drawRect(0, 0, this.getWidth(), this.getHeight());
    }
}
