import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Video extends JPanel {
    private boolean isPlayed;
    private boolean isWindow;

    public Video (String path){
        EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        mediaPlayerComponent.setSize(140,140);
        mediaPlayerComponent.setPreferredSize(new Dimension(140,140));
        setSize(160,160);
        setPreferredSize(new Dimension(160,160));
        add(mediaPlayerComponent, BorderLayout.NORTH);
        add(new JLabel(path), BorderLayout.SOUTH);

        isPlayed = false;

        setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("gay");
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1){
                    MediaPlayer mediaPlayer = mediaPlayerComponent.mediaPlayer();
                    if (!isPlayed){
                        mediaPlayer.media().play(Main.path2file.substring(0, Main.path2file.lastIndexOf("\\") + 1) + path);
                        isPlayed = true;
                    } else {
                        mediaPlayer.controls().pause();
                        isPlayed = false;
                    }
                } else if (e.getButton() == MouseEvent.BUTTON2){
                    if (!isWindow) {
                        isWindow = true;
                        VideoPlayer player = new VideoPlayer(path);
                        isPlayed = true;
                    }
                }
            }
        });
    }
}
