import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageViewer extends JFrame {
    ImageViewer(String path){
        BufferedImage img = null;
        ImageIcon icon = null;

        try {
            img = ImageIO.read(new File(Main.path2file.substring(0, Main.path2file.lastIndexOf("\\") + 1) + path));
            img = Image.rescaleImg(img,1280,700);
            icon = new ImageIcon(img);
        } catch (IOException e) {

        }

        setName(path);
        Dimension size = new Dimension(1280, 720);
        setPreferredSize(size);
        setSize(size);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JLabel lbl = new JLabel(path);

        lbl.setHorizontalTextPosition(SwingConstants.CENTER);
        lbl.setVerticalTextPosition(SwingConstants.BOTTOM);

        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setVerticalAlignment(SwingConstants.CENTER);

        if (icon != null){
            lbl.setIcon(icon);
        }

        add(lbl,BorderLayout.CENTER);

        pack();
        setVisible(true);
    }
}
