import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VideoPlayer extends JFrame {
    private boolean isPlaying;

    VideoPlayer(String path) {
        isPlaying = true;

        setName(path);
        Dimension size = new Dimension(1280, 720);
        setPreferredSize(size);
        setSize(size);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        EmbeddedMediaPlayerComponent mediaFrame = new EmbeddedMediaPlayerComponent();

        add(mediaFrame);

        setVisible(true);

        final MediaPlayer mediaP = mediaFrame.mediaPlayer();
        mediaP.media().play(Main.path2file.substring(0, Main.path2file.lastIndexOf("\\") + 1) + path);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mediaFrame.release();
                dispose();
            }
        });

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT -> mediaP.controls().skipTime(50);
                    case KeyEvent.VK_LEFT -> mediaP.controls().skipTime(50);
                    case KeyEvent.VK_SPACE -> {
                        if (isPlaying) {
                            mediaP.controls().pause();
                            isPlaying = false;
                        } else {
                            mediaP.controls().play();
                            isPlaying = true;
                        }
                    }
                    default -> {
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}
