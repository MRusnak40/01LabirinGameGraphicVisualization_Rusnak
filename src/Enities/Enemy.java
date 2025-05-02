package Enities;

import MainLoop.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Enemy extends Rectangle {

    private int speed;

    private boolean isMoving;
    private String name;
    ImageIcon imageIcon;
    Color color;
    Player player;
    MyFrame frame;

    public Enemy(int x, int y, int width, int height, Color color, Player player, MyFrame frame) {
        super(x, y, width, height);
        this.color = color;
        this.player = player;
        this.frame = frame;
    }


    public void movement() {
        if (player.steps > 5) {
            if(!player.isSolving) {
                if (!player.listOfTracks.isEmpty()) {

                    this.x = player.listOfTracks.getFirst().getX();
                    this.y = player.listOfTracks.getFirst().getY();

                    player.listOfTracks.removeFirst();
                } else {
                    // Poslední krok — ujisti se, že enemy dojde na aktuální pozici hráče
                    if (this.x != player.x || this.y != player.y) {
                        this.x = player.x;
                        this.y = player.y;
                    }

                }
            }
        }
        //System.out.println(player.x + " " + player.y);

    }


    public void update() {
        // Update enemy position or logic
        /*
        movement();


         */
        movement();
        frame.checkColision();
        frame.repaint();
    }


    public void draw(Graphics g) {
        imageIcon = new ImageIcon("Files/enemy.png");
        // g.setColor(this.color);
        // g.fillRect(this.x, this.y, this.width, this.height);
        g.drawImage(imageIcon.getImage(), x, y, width, height, null);

    }


}
