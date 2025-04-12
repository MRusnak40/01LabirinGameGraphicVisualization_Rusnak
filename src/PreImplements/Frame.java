package PreImplements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame extends JFrame {
    /*
    Image image;
    Graphics graphics;
    Box player;
    Box enemy;
    Boolean gameOver = false;

    public Frame() {
        player = new Box(100, 300, 50, 50, Color.CYAN);
        enemy = new Box(600, 600, 50, 50, Color.RED);


        int widthWindow = 1500;
        int heightWindow = 900;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Advanture labirint");
        this.setSize(widthWindow, heightWindow);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);


        this.addKeyListener(new Al());


        this.setVisible(true);
    }

    public void paint(Graphics g) {
        image = createImage(this.getWidth(), this.getHeight());
        graphics = image.getGraphics();
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);



        player.draw(g);
        enemy.draw(g);
        if (gameOver == true) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 100));
            g.drawString("Game Over", 100, 200);
        }


    }

    public void checkColision() {
        if (player.intersects(enemy)) {
            gameOver = true;
            System.out.println("Game Over");
        }
    }


    public class Al extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
            checkColision();
            repaint();
        }
    }

     */
}
