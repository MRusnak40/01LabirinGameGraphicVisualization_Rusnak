package LoadingFromFiles;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class LoadTextures {
    private String fileName;


    public static ImageIcon loadImage(String path) {
        try {

            //read the image from the path
            BufferedImage image = ImageIO.read(new File(path));

            //returns image on icon
            return new ImageIcon(image);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
