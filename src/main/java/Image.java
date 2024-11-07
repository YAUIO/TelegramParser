import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image extends JLabel {
    private ImageViewer viewer;

    public static BufferedImage rescaleImg(BufferedImage img, int width, int height){
        int newWidth = img.getWidth();
        int newHeight = img.getHeight();
        Double multiplier = null;
        if (img.getWidth() > width || img.getHeight() > height) {
            if (width / img.getWidth() < height / img.getHeight()) {
                multiplier = (double) width / img.getWidth();
            } else {
                multiplier = (double) height / img.getHeight();
            }
            if (multiplier-0.04>0){
                multiplier -= 0.04;
            }
            newWidth = (int) (newWidth * multiplier);
            newHeight = (int) (newHeight * multiplier);
        } else if (img.getWidth() < width || img.getHeight() < height) {
            if (width / img.getWidth() < height / img.getHeight()) {
                multiplier = (double) width / img.getWidth();
            } else {
                multiplier = (double) height / img.getHeight();
            }
            if (multiplier-0.1>0){
                multiplier -= 0.1;
            }
            newWidth = (int) (newWidth * multiplier);
            newHeight = (int) (newHeight * multiplier);
        }

        BufferedImage out = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D buf = out.createGraphics();
        buf.drawImage(img, 0, 0, newWidth, newHeight, null);
        buf.dispose();
        return out;
    }

    Image(String path){
        viewer = null;

        BufferedImage img = null;
        ImageIcon icon = null;

        try {
            img = ImageIO.read(new File(Main.path2file.substring(0, Main.path2file.lastIndexOf("\\") + 1) + path));
            img = rescaleImg(img,140,140);
            icon = new ImageIcon(img);
        } catch (IOException e) {

        }

        if (icon != null){
            this.setIcon(icon);
        }

        this.setSize(160,160);
        setHorizontalTextPosition(JLabel.CENTER);
        setVerticalTextPosition(JLabel.BOTTOM);
        this.setPreferredSize(new Dimension(120,160));
        if (path.length()>20){
            this.setSize(120+6*(path.length()-20),160);
            this.setPreferredSize(new Dimension(120+6*(path.length()-20),160));
        }
        this.setText(path);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (viewer != null && !viewer.isDisplayable()){
                    viewer = null;
                }

                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (viewer == null) {
                        viewer = new ImageViewer(path);
                    }
                }
            }
        });
    }
}
