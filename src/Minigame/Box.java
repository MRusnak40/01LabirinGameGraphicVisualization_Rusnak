package Minigame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Box extends Rectangle {

    Color color;
    private static final int SPEED = 10;
    Map walls;
public ImageIcon imageIcon;
    Box(int x, int y, int width, int height, Color color, Map walls,ImageIcon imageIcon) {
        this.x = x;
        this.y = y;
        this.walls = walls;
        this.width = width;
        this.height = height;
        this.color = color;
        this.imageIcon = imageIcon;


    }

    public void keyPressed(KeyEvent e) {
        int nextX = x;
        int nextY = y;

        int[][] maze = walls.getMaze();
        int cellSize = 100;

        switch (e.getKeyCode()) {

            case KeyEvent.VK_LEFT:
                nextX -= SPEED;
                break;
            case KeyEvent.VK_RIGHT:
                nextX += SPEED;
                break;
            case KeyEvent.VK_UP:
                nextY -= SPEED;
                break;
            case KeyEvent.VK_DOWN:
                nextY += SPEED;
                break;
        }

        int col = nextX / cellSize;
        int row = nextY / cellSize;

        if (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length) {
            if (maze[row][col] == 0) {
                x = nextX;
                y = nextY;
            }else if(maze[row][col] == 2){

            }
        }

    }

    public void draw(Graphics g) {



        // g.setColor(this.color);
        // g.fillRect(this.x, this.y, this.width, this.height);

        g.drawImage(imageIcon.getImage(), x, y, width, height, null);

    }

}
