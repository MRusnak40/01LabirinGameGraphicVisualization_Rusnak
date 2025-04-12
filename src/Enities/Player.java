package Enities;

import MainLoop.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Rectangle {


    Color color;
    public boolean isAlive;
    public String name;
    public int score;
    public int spawnx;
    public int spawny;
    public ImageIcon imageIcon;

    public Player(int x, int y, int width, int height, Color color, ImageIcon imageIcon) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.imageIcon = imageIcon;

    }


    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_LEFT:
                this.x -= 10;
                break;
            case KeyEvent.VK_RIGHT:
                this.x += 10;
                break;

            case KeyEvent.VK_UP:
                this.y -= 10;
                break;
            case KeyEvent.VK_DOWN:
                this.y += 10;
                break;
        }


    }

    public void draw(Graphics g) {
        imageIcon=new ImageIcon("Files/Player.png");


       // g.setColor(this.color);
       // g.fillRect(this.x, this.y, this.width, this.height);
        g.drawImage(imageIcon.getImage(), x, y, width, height, null);
    }


}
