import javax.swing.*;
import java.awt.*;

public class Parser extends Thread{
    private JFrame window;
    private JScrollPane mainPane;
    private JList<GUIMessage> parsedLog;
    private JMenuBar menu;
    private Chat log;

    Parser(Chat chat){
        window = new JFrame("TelegramParser by YAUIO");
        Dimension size = new Dimension(1280,720);
        window.setPreferredSize(size);
        window.setSize(size);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        log = chat;

        GUIMessage[] arr = new GUIMessage[log.messages.size()];
        int i = 0;

        for (Message m : log.messages){
            arr[i] = new GUIMessage(m);
            i++;
        }

        parsedLog = new JList<>(arr);

        mainPane = new JScrollPane();

        mainPane.setViewportView(parsedLog);

        parsedLog.setLayoutOrientation(JList.VERTICAL);

        menu = new JMenuBar();

        window.setJMenuBar(menu);

        window.add(mainPane);

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
