package Enities;

import MainLoop.MyFrame;
import Map.Walls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player extends Rectangle {

    Walls wall;
    Color color;
    public boolean isAlive;
    private String name = " ";
    public int steps;
    public int currentx;
    public int currenty;
    public ImageIcon imageIcon;
    public final int speed = 15;
    public boolean isOnEndPlayer = false;
    public ArrayList<Track> listOfTracks;
    MyFrame frame;
    //NameTag nameTag = new NameTag(name, this.x, this.y);
    NameTag nameTag;

    public Player(int x, int y, int width, int height, Color color, ImageIcon imageIcon, Walls wall, MyFrame frame, String name) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.imageIcon = imageIcon;
        this.wall = wall;
        this.listOfTracks = new ArrayList<>();
        this.frame = frame;
        this.name = name;
        this.nameTag = new NameTag(this.name, this.x, this.y);
    }


    public void keyPressed(KeyEvent e) {
        Walls walls = new Walls();
        int[][] maze = walls.getMaze();
        int cellSize = 40;

        int nextX = x;
        int nextY = y;


        //creating list where enemy will follow
        listOfTracks.add(new Track(nextX, nextY));
        steps++;

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

        // recounting position to cells map
        int col = nextX / cellSize;
        int row = nextY / cellSize;

        // save from IndexOutOfBounds
        if (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length) {
            if (maze[row][col] == 0) { // 0 = cesta


                x = nextX;
                y = nextY;

                currentx = x;
                currenty = y;

            } else if (maze[row][col] == 2) {

                isOnEndPlayer = true;
                //  System.exit(0);

            } else if (maze[row][col] == 3) { // fakedoors

                wall.maze[row][col] = 0;
                x = nextX;
                y = nextY;

                currentx = x;
                currenty = y;

            } else if (maze[row][col] == 4) {//math doors

                wall.maze[row][col] = 0;

                x = nextX;
                y = nextY;

                currentx = x;
                currenty = y;

            } else if (maze[row][col] == 5) {//texture minigame doors
                wall.maze[row][col] = 0;
                x = nextX;
                y = nextY;

                currentx = x;
                currenty = y;
            } else if (maze[row][col] == 6) {//doors with qestions




                x = nextX;
                y = nextY;

                currentx = x;
                currenty = y;
                wall.maze[row][col] = 0;
            }

        }
    }


    public void draw(Graphics g) {
        imageIcon = new ImageIcon("Files/Player.png");


        // g.setColor(this.color);
        // g.fillRect(this.x, this.y, this.width, this.height);
        g.drawImage(imageIcon.getImage(), x, y, width, height, null);
        nameTag.draw(g);
    }

    public void update() {
        // Update enemy position or logic
        nameTag.setPosition(this.x, this.y);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
