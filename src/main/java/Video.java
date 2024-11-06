import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class Video extends JPanel {
    public Video (String path){
        EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        mediaPlayerComponent.setSize(140,140);
        mediaPlayerComponent.setPreferredSize(new Dimension(140,140));
        setSize(160,160);
        setPreferredSize(new Dimension(160,160));
        add(new JLabel(path), BorderLayout.SOUTH);
        add(mediaPlayerComponent);

        setVisible(true);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { //ADD PAUSE PLAY AND FULLSCREEN
                MediaPlayer mediaPlayer = mediaPlayerComponent.mediaPlayer();
                mediaPlayer.media().play(Main.path2file.substring(0, Main.path2file.lastIndexOf("\\") + 1) + path);
                System.out.println("gay");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
