package SubTasks;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MinigameFrame extends JFrame {
    public int widthWindow;
    public int heightWindow;
    BufferedImage bufferedImage;
    Graphics2D g2;
    public MinigameFrame() {

        widthWindow = 1520;
        heightWindow = 1020;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Mini Game");
        this.setSize(widthWindow, heightWindow);
        this.setBackground(Color.BLACK);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setLayout(null);


        addComponents();


    }


    public void addComponents() {



    }


    public void paint(Graphics g) {

        // Vytvoření off-screen bufferu (pouze JEDNOU, ne pokaždé v paint)

        if (bufferedImage == null) {
            bufferedImage = new BufferedImage(widthWindow, heightWindow, BufferedImage.TYPE_INT_ARGB);
        }

        g2 = bufferedImage.createGraphics();

        // Vyčisti pozadí
        g2.setColor(getBackground());
        g2.fillRect(0, 0, getWidth(), getHeight());

        // Paint objects
        walls.paint(g2);
        player.draw(g2);
        enemy.draw(g2);




        // Přenes obraz z bufferu na obrazovku
        g.drawImage(bufferedImage, 0, 0, this);

        g2.dispose(); // ukončíme práci s g2, ne s g!

    }


    public void update(){


    }


}
