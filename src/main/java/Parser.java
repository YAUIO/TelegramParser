import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Parser extends Thread{
    public final JFrame window;
    private final JPList parsedLog;
    private final JMenuBar menu;
    public final JScrollPane scrollPane;
    public final Chat log;

    Parser(Chat chat){
        window = new JFrame("TelegramParser by YAUIO");
        Dimension size = new Dimension(1280,720);
        window.setPreferredSize(size);
        window.setSize(size);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        log = chat;

        parsedLog = new JPList(log.messages,this);

        menu = new JMenuBar();

        Search search = new Search();

        menu.add(search);

        window.setJMenuBar(menu);

        scrollPane = new JScrollPane(parsedLog);

        scrollPane.getVerticalScrollBar().setUnitIncrement(24);

        window.add(scrollPane);

        window.pack();

        window.setVisible(true);

        this.start();
    }

    public void goTo(int id){
        scrollPane.getVerticalScrollBar().setValue((id-log.messages.getFirst().id)*168);
    }

    public void error(String title, String message){
        JOptionPane.showMessageDialog(window, message,
                title, JOptionPane.ERROR_MESSAGE);
    }

    public void error(String message){
        JOptionPane.showMessageDialog(window, message,
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void run() {
        super.run();

        while (true);
    }

    public class Search extends JMenu {
        Search(){
            setText("Search");

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    System.out.println(e.getButton());
                }
            });
        }
    }
}
