import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Video extends JPanel {
    private boolean isWindow;
    private VideoPlayer player;

    public Video (String path, Parser p){
        player = null;

        EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        mediaPlayerComponent.setSize(140,140);
        mediaPlayerComponent.setPreferredSize(new Dimension(140,140));
        setSize(160,160);
        setPreferredSize(new Dimension(160,160));
        add(mediaPlayerComponent, BorderLayout.NORTH);
        add(new JLabel(path), BorderLayout.SOUTH);

        setVisible(true);

        final MediaPlayer mediaPlayer = mediaPlayerComponent.mediaPlayer();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //fix clickable area
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1){

                    if (!player.isDisplayable()) {
                        player = null;
                    }

                    if (!mediaPlayer.status().isPlaying() && player == null){
                        mediaPlayer.media().play(Main.path2file.substring(0, Main.path2file.lastIndexOf("\\") + 1) + path);
                    } else if (player != null){
                        mediaPlayer.controls().pause();
                        p.error("Close external window before playing internally");
                    } else {
                        mediaPlayer.controls().pause();
                    }
                } else if (e.getButton() == MouseEvent.BUTTON2){
                    if (!isWindow) {
                        isWindow = true;
                        player = new VideoPlayer(path);
                    }
                }
            }
        });
    }
}
