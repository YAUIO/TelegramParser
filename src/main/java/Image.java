import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image extends JLabel {
    BufferedImage img;
    ImageIcon icon;

    private static BufferedImage rescaleImg(BufferedImage img, int newWidth, int newHeight){
        BufferedImage out = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D buf = out.createGraphics();
        buf.drawImage(img, 0, 0, newWidth, newHeight, null);
        buf.dispose();
        return out;
    }

    Image(String path){
        try {
            img = ImageIO.read(new File(Main.path2file.substring(0, Main.path2file.lastIndexOf("\\") + 1) + path));
            img = rescaleImg(img,140,140);
            icon = new ImageIcon(img);
        } catch (IOException e) {

        }

        this.setIcon(icon);
        this.setSize(160,160);
        setHorizontalTextPosition(JLabel.CENTER);
        setVerticalTextPosition(JLabel.BOTTOM);
        this.setPreferredSize(new Dimension(120,160));
        if (path.length()>20){
            this.setSize(120+6*(path.length()-20),160);
            this.setPreferredSize(new Dimension(120+6*(path.length()-20),160));
        }
        this.setText(path);
    }
}
