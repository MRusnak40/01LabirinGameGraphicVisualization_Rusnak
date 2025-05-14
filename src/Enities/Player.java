package Enities;

import MainLoop.MyFrame;
import Map.DoorsWithMath;
import Map.DoorsWithMiniGame;
import Map.DoorsWithQestions;
import Map.Walls;
import SubWindows.StartWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class Player extends Rectangle {

    Walls wall;
    Color color;
    public boolean isSolving = false;
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
    DoorsWithQestions doorsWithQestions = new DoorsWithQestions(false);
    DoorsWithMiniGame doorsWithMiniGame;
    DoorsWithMath doorsWithMath = new DoorsWithMath(false);
    Walls walls;

    public Player(int x, int y, int width, int height, Color color, ImageIcon imageIcon, Walls wall, MyFrame frame, String name, Walls walls) {
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
        this.walls = walls;
    }


    public void keyPressed(KeyEvent e) {

        int[][] maze = walls.getMaze();
        int cellSize = 40;

        int nextX = x;
        int nextY = y;

        if (!frame.gameOver) {
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
                    isSolving = true;
                    int option = JOptionPane.showConfirmDialog(null, "You won. Do you want to continue?", "Victory", JOptionPane.OK_CANCEL_OPTION);

                    if (option == JOptionPane.CANCEL_OPTION || option == JOptionPane.CLOSED_OPTION) {
                        System.exit(0); // Ukončí program
                    } else {
                        isSolving = false;
                        frame.dispose();
                        new StartWindow();
                    }


                    //  System.exit(0);

                } else if (maze[row][col] == 3) { // fakedoors

                    wall.maze[row][col] = 0;
                    x = nextX;
                    y = nextY;

                    currentx = x;
                    currenty = y;

                } else if (maze[row][col] == 4) {//math doors


                    isSolving = true;

                    if (doorsWithMath.showMathTask()) {
                        wall.maze[row][col] = 0;
                        isSolving = false;

                    } else {
                        frame.gameOver = true;
                        isSolving = false;

                    }


                    x = nextX;
                    y = nextY;

                    currentx = x;
                    currenty = y;

                } else if (maze[row][col] == 5) {//texture minigame doors

                    isSolving = true;
                    doorsWithMiniGame = new DoorsWithMiniGame(false,frame);

                    doorsWithMiniGame.miniGame();

/*
                    if (doorsWithMiniGame.isUnlocked()) {
                        wall.maze[row][col] = 0;
                        isSolving = false;

                    } else {
                        frame.gameOver = true;
                        isSolving = false;

                    }


 */
                    x = nextX;
                    y = nextY;

                    currentx = x;
                    currenty = y;


                } else if (maze[row][col] == 6) {//doors with qestions

                    isSolving = true;
                    if (doorsWithQestions.answer()) {
                        maze[row][col] = 0;
                        isSolving = false;

                    } else {
                        frame.gameOver = true;
                        isSolving = false;
                    }

                    x = nextX;
                    y = nextY;


                    currentx = x;
                    currenty = y;


                }

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
