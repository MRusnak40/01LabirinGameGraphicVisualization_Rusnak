package Tests;

import LoadingFromFiles.LoadTextures;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class LoadTexturesTest {
    LoadTextures loader = new LoadTextures();
    @Test
    void testLoadImage_Success() {
        // Předpokládej, že v resources je test.png
        String path = "Files/enemy.png";


        ImageIcon icon = loader.loadImage(path);

        assertNotNull(icon, "ImageIcon should not be null for a valid image");
        assertNotNull(icon.getImage(), "Image should not be null inside ImageIcon");
    }
    @Test
    void testLoadImage_FileNotFound() {
        String path = "sada";
        ImageIcon icon = loader.loadImage(path);

        assertNull(icon, "ImageIcon should be null if file does not exist");
    }
}