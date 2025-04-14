package Enities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Enemy extends Rectangle {

    private int speed;
    private int spawnx;
    private int spawny;
    private boolean isMoving;
    private String name;
ImageIcon imageIcon;
    Color color;


    public Enemy(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;


    }


public void movement(){


}


    public void update() {
        // Update enemy position or logic
    }





    public void draw(Graphics g) {
        imageIcon=new ImageIcon("Files/enemy.png");
        // g.setColor(this.color);
        // g.fillRect(this.x, this.y, this.width, this.height);
        g.drawImage(imageIcon.getImage(), x, y, width, height, null);
    }


}
