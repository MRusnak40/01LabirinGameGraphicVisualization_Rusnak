package Enities;

import MainLoop.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Enemy extends Rectangle {

    private int speed;
    private int x;
    private int y;
    private boolean isMoving;
    private String name;
    ImageIcon imageIcon;
    Color color;
    Player player;
    MyFrame frame;

    public Enemy(int x, int y, int width, int height, Color color, Player player, MyFrame frame) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.player = player;
        this.frame = frame;
    }


    public void movement() {
        if (!player.listOfTracks.isEmpty()) {

            x = player.listOfTracks.getFirst().getX();
            y = player.listOfTracks.getFirst().getY();

            player.listOfTracks.removeFirst();
        }
        System.out.println(player.x + " " + player.y);

    }


    public void update() {
        // Update enemy position or logic
        /*
        movement();


         */
        movement();

    }


    public void draw(Graphics g) {
        imageIcon = new ImageIcon("Files/enemy.png");
        // g.setColor(this.color);
        // g.fillRect(this.x, this.y, this.width, this.height);
        g.drawImage(imageIcon.getImage(), x, y, width, height, null);

    }


}
