package Minigame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Represents a game map panel that displays a maze with walls, roads, and finish point.
 * The maze is rendered using loaded textures for each element.
 */
public class Map extends JPanel {
    private static final int CELL_SIZE = 100; // size cell
    private BufferedImage wallTexture; // Textura zdi
    private BufferedImage roadTexture;
    private BufferedImage finishTexture;
    // Labyrint (1 = wall, 0 = road)
    public int[][] maze = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 2, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };


    /**
     * Constructs a new Map instance.
     * Initializes the map by loading required textures for walls, roads, and finish point from files.
     */
    public Map() {
        try {
            // Načtení textury zdi
            wallTexture = ImageIO.read(new File("Files/walls.png"));
            roadTexture = ImageIO.read(new File("Files/sendRoad.png"));


            roadTexture = ImageIO.read(new File("Files/sendRoad.png"));

            finishTexture = ImageIO.read(new File("Files/finish.png"));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * Renders the maze components on the panel.
     * Draws walls, roads, and finish point using their respective textures.
     * Each cell is drawn according to the maze array where:
     * 1 represents walls, 0 represents roads, and 2 represents the finish point.
     *
     * @param g the Graphics object used for painting
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
//paints the walss
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {


                if (maze[row][col] == 1) {
                    // wall
                    g2d.drawImage(wallTexture, col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE, null);


                } else if (maze[row][col] == 0) {



//road
                    g2d.drawImage(roadTexture, col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE, null);


                } else if (maze[row][col] == 2) {
//finish
                    g2d.drawImage(finishTexture, col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE, null);

                }


            }
        }
    }


    /**
     * Returns the current maze layout.
     *
     * @return 2D array representing the maze where 1 is wall, 0 is road, and 2 is finish
     */
    public int[][] getMaze() {
        return maze;
    }


}

