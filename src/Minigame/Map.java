package Minigame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

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


    // constructor
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


    // method for paint
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


                    /*
                    // road
                    g2d.setColor(Color.WHITE);
                    g2d.fillRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                     */
//road
                    g2d.drawImage(roadTexture, col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE, null);


                } else if (maze[row][col] == 2) {
//finish
                    g2d.drawImage(finishTexture, col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE, null);

                }

                //System.out.println("Row: " + row + ", Col: " + col + ", X: " + (col * CELL_SIZE) + ", Y: " + (row * CELL_SIZE));

            }
        }
    }


    public int[][] getMaze() {
        return maze;
    }

    public void setMaze(int[][] maze) {
        this.maze = maze;
    }
}

