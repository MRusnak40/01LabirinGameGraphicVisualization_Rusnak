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

    /**
     * Creates a new Enemy object with specified position, dimensions and references.
     *
     * @param x      The x-coordinate position of the enemy
     * @param y      The y-coordinate position of the enemy
     * @param width  The width of the enemy
     * @param height The height of the enemy
     * @param color  The color of the enemy
     * @param player Reference to the player object
     * @param frame  Reference to the main game frame
     */
    public Enemy(int x, int y, int width, int height, Color color, Player player, MyFrame frame) {
        super(x, y, width, height);
        this.color = color;
        this.player = player;
        this.frame = frame;
    }


    /**
     * Updates the enemy's position based on the player's movement track.
     * Enemy follows player's path if player has moved more than 5 steps and is not solving a puzzle.
     */
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


    /**
     * Updates the enemy's state by moving it, checking for collisions and repainting the frame.
     */
    public void update() {

        movement();
        frame.checkColision();
        frame.repaint();
    }


    /**
     * Draws the enemy on the specified Graphics context using an image icon.
     *
     * @param g The Graphics context on which to draw the enemy
     */
    public void draw(Graphics g) {
        imageIcon = new ImageIcon("Files/enemy.png");

        g.drawImage(imageIcon.getImage(), x, y, width, height, null);

    }


}
