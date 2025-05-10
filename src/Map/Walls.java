package Map;

import MainLoop.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Walls extends JPanel {
    private static final int CELL_SIZE = 40; // size cell
    private static final int SCREEN_WIDTH = 1500; // Šířka obrazovky
    private static final int SCREEN_HEIGHT = 1000; // Výška obrazovky
    private BufferedImage wallTexture; // Textura zdi
    private BufferedImage roadTexture;
    private BufferedImage finishTexture;
    private BufferedImage doorTextureFake;
    private BufferedImage doorTextureMiniGame;
    private BufferedImage doorTextureMath;
    private BufferedImage doorTextureQestions;
    // Labyrint (1 = wall, 0 = road)
    public int[][] maze = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},//38
            {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1},
            {1, 2, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1},
            {1, 0, 0, 4, 0, 0, 0, 0, 1, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 3, 1},
            {1, 2, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 0, 0, 4, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
            {1, 1, 0, 1, 1, 1, 3, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1},
            {1, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1},
            {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 5, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1},
            {1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1},
            {1, 0, 0, 3, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1},
            {1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 3, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 3, 1, 0, 0, 1},
            {1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 3, 1},
            {1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 6, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 4, 0, 0, 1, 3, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 3, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };


    // constructor
    public Walls() {
        try {
            // Načtení textury zdi
            wallTexture = ImageIO.read(new File("Files/walls.png"));
            roadTexture = ImageIO.read(new File("Files/sendRoad.png"));


            doorTextureFake = ImageIO.read(new File("Files/dorrsWithQestins.png"));
            doorTextureMath = ImageIO.read(new File("Files/MatematicDoors.png"));
            doorTextureQestions = ImageIO.read(new File("Files/dorrsWithQestins.png"));
            doorTextureMiniGame = ImageIO.read(new File("Files/dorsMiniGame.png"));

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

                } else if (maze[row][col] == 3) {
//fakedoors
                    g2d.drawImage(doorTextureFake, col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE, null);

                } else if (maze[row][col] == 4) {
//math doors
                    g2d.drawImage(doorTextureMath, col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE, null);

                } else if (maze[row][col] == 5) {
//texture minigame doors
                    g2d.drawImage(doorTextureMiniGame, col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE, null);

                } else if (maze[row][col] == 6) {
//doors with qestions
                    g2d.drawImage(doorTextureQestions, col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE, null);
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
