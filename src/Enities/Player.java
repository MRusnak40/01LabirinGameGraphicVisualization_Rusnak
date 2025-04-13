package Enities;

import MainLoop.MyFrame;
import Map.Walls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Rectangle {


    Color color;
    public boolean isAlive;
    public String name;
    public int score;
    public int currentx;
    public int currenty;
    public ImageIcon imageIcon;
    public final int speed = 15;


    public Player(int x, int y, int width, int height, Color color, ImageIcon imageIcon) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.imageIcon = imageIcon;

    }


    public void keyPressed(KeyEvent e) {
        Walls walls = new Walls();
        int[][] maze = walls.getMaze();
        int cellSize = 40;

        int nextX = x;
        int nextY = y;

        // Ovládání (zjisti novou pozici před pohybem)
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                nextX -= speed;
                break;
            case KeyEvent.VK_RIGHT:
                nextX += speed;
                break;
            case KeyEvent.VK_UP:
                nextY -= speed;
                break;
            case KeyEvent.VK_DOWN:
                nextY += speed;
                break;

        }

        // Přepočet souřadnic na pozici v mřížce
        int col = nextX / cellSize;
        int row = nextY / cellSize;

        // Ochrana proti IndexOutOfBounds
        if (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length) {
            if (maze[row][col] == 0) { // 0 = cesta
                x = nextX;
                y = nextY;

                currentx = x;
                currenty = y;
            }
            // Jinak nic – je tam zeď, nepohne se
        }
    }
/*
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

 */

    public void draw(Graphics g) {
        imageIcon = new ImageIcon("Files/Player.png");


        // g.setColor(this.color);
        // g.fillRect(this.x, this.y, this.width, this.height);
        g.drawImage(imageIcon.getImage(), x, y, width, height, null);
    }


}
