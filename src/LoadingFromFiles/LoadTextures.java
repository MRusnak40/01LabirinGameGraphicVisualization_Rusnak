package LoadingFromFiles;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Class responsible for loading texture images from files.
 */
public class LoadTextures {



    /**
     * Loads an image from the specified file path and converts it to an ImageIcon.
     *
     * @param path The file path to the image
     * @return ImageIcon containing the loaded image, or null if loading fails
     */
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
