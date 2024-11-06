import javax.swing.*;
import java.awt.*;

public class Parser extends Thread{
    public final JFrame window;
    private final JPList parsedLog;
    private final JMenuBar menu;
    private final Chat log;

    Parser(Chat chat){
        window = new JFrame("TelegramParser by YAUIO");
        Dimension size = new Dimension(1280,720);
        window.setPreferredSize(size);
        window.setSize(size);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        log = chat;

        parsedLog = new JPList(log.messages,this);

        menu = new JMenuBar();

        window.setJMenuBar(menu);

        JScrollPane jsp = new JScrollPane(parsedLog);

        jsp.getVerticalScrollBar().setUnitIncrement(24);

        window.add(jsp);

        window.pack();

        window.setVisible(true);

        this.start();
    }

    @Override
    public void run() {
        super.run();

        while (true);
    }
}
