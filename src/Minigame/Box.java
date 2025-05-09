package Minigame;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Box extends Rectangle {

    Color color;
    private static final int SPEED = 10;

    Box(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;


    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {

            case KeyEvent.VK_LEFT:
                x -= SPEED;
                break;
            case KeyEvent.VK_RIGHT:
                x += SPEED;
                break;
            case KeyEvent.VK_UP:
                y -= SPEED;
                break;
            case KeyEvent.VK_DOWN:
                y += SPEED;
                break;
        }

    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);


    }
}
