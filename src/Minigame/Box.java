package Minigame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import Enities.Player;
import Map.DoorsWithMiniGame;

public class Box extends Rectangle {

    Color color;
    private static final int SPEED = 10;
    Map walls;
    public ImageIcon imageIcon;
    MinigameFrame frame;
    MinigameLoop loop;
    DoorsWithMiniGame doorsWithMiniGame;
    Player player;

    /**
     * Creates a new Box instance for the minigame
     *
     * @param x                 initial x-coordinate position
     * @param y                 initial y-coordinate position
     * @param width             width of the box
     * @param height            height of the box
     * @param color             color of the box
     * @param walls             reference to the maze walls
     * @param imageIcon         image icon for box visualization
     * @param frame             reference to the minigame frame
     * @param doorsWithMiniGame reference to the door with minigame
     * @param loop              reference to the minigame loop
     * @param player            reference to the player
     */
    Box(int x, int y, int width, int height, Color color, Map walls, ImageIcon imageIcon, MinigameFrame frame, DoorsWithMiniGame doorsWithMiniGame, MinigameLoop loop, Player player) {
        this.x = x;
        this.y = y;
        this.walls = walls;
        this.width = width;
        this.height = height;
        this.color = color;
        this.imageIcon = imageIcon;
        this.frame = frame;
        this.doorsWithMiniGame = doorsWithMiniGame;
        this.loop = loop;
        this.player = player;
    }

    /**
     * Handles keyboard input for box movement and collision detection
     *
     * @param e the key event containing information about the pressed key
     */
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
            } else if (maze[row][col] == 2) {
                doorsWithMiniGame.setUnlocked(true);

                player.maze[player.rowCurrnet][player.colCurrent] = 0;


                loop.setRunningMiniGame(false);

                player.isSolving = false;


                frame.win = true;

                loop.setRunningMiniGame(false);

                frame.dispose();
            } else if (maze[row][col] == 1) {
                //death
                doorsWithMiniGame.setUnlocked(false);
                frame.dispose();
                frame.myFrame.gameOver = true;
                loop.setRunningMiniGame(false);
                player.isSolving = false;

            }
        }

    }

    /**
     * Renders the box on the screen
     *
     * @param g the graphics context used for drawing
     */
    public void draw(Graphics g) {
        g.drawImage(imageIcon.getImage(), x, y, width, height, null);

    }

}
