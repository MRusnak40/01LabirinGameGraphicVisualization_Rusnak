package Minigame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import Enities.Player;
import MainLoop.MyFrame;
import Map.Walls;
import Map.DoorsWithMiniGame;

public class MinigameFrame extends JDialog {

    private int widthWindow;
    private int heightWindow;
    BufferedImage bufferedImage;
    Graphics2D g2;
    boolean win = false;
    boolean gameOver = false;
    Box player;
    Map map = new Map();
    DoorsWithMiniGame doorsWithMiniGame;
    MyFrame myFrame;
    MinigameLoop loop;
Player mainPlayer;

    /**
     * Constructor for MinigameFrame class
     *
     * @param doorsWithMiniGame The door object that triggered this minigame
     * @param myFrame           The main game frame reference
     * @param loop              The minigame loop object
     * @param player            The main player object
     * @throws HeadlessException If GraphicsEnvironment.isHeadless() returns true
     */
    public MinigameFrame(DoorsWithMiniGame doorsWithMiniGame, MyFrame myFrame, MinigameLoop loop,Player player) throws HeadlessException {
        this.doorsWithMiniGame = doorsWithMiniGame;
        this.loop = loop;
        this.myFrame = myFrame;
        widthWindow = 1000;
        heightWindow = 1000;
        this.mainPlayer = player;

        this.setTitle("Advanture labirint");
        this.setSize(widthWindow, heightWindow);
        this.setModal(true);
        createPlayers();

        this.setBackground(Color.BLACK);


        this.setResizable(false);
        this.setLocationRelativeTo(null);
//set player size


        //walls.setPreferredSize(new Dimension(widthWindow, heightWindow));

        this.setLayout(new BorderLayout());

        this.addKeyListener(new Al());
        this.getContentPane().setBackground(Color.BLUE);

        ImageIcon imageIcon = new ImageIcon("Files/betterQualityFrameIcon.png");
        setIconImage(imageIcon.getImage());

        createWalls();


        this.setVisible(true);


    }

    /**
     * Creates and initializes the walls for the minigame
     */
    public void createWalls() {
        map.setPreferredSize(new Dimension(widthWindow, heightWindow));
        this.add(map, BorderLayout.CENTER);
    }





    //By chat gpt






    /**
     * Paints the game components using double buffering
     *
     * @param g The Graphics object to paint on
     */
    @Override
    public void paint(Graphics g) {
        // Vytvoření off-screen bufferu (pouze JEDNOU, ne pokaždé v paint)
        if (bufferedImage == null) {
            bufferedImage = new BufferedImage(widthWindow, heightWindow, BufferedImage.TYPE_INT_ARGB);
        }

        g2 = bufferedImage.createGraphics();

        // Vyčisti pozadí
        g2.setColor(getBackground());
        g2.fillRect(0, 0, getWidth(), getHeight());

        // Vykresli herní objekty
        map.paint(g2);
        player.draw(g2);





        // Přenes obraz z bufferu na obrazovku
        g.drawImage(bufferedImage, 0, 0, this);

        g2.dispose(); // ukončíme práci s g2, ne s g!
    }




    //				 ↑			  ↑					↑









    /**
     * Inner class for handling keyboard input
     */
    private class Al extends KeyAdapter {
        /**
         * Handles key press events
         *
         * @param e The KeyEvent object containing information about the key press
         */
        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);

            repaint();

        }
    }


    /**
     * Creates and initializes the player object
     */
    public void createPlayers() {


//x 1250 y 930
        //y,x= 100

        player = new Box(100, 200, 100, 100, Color.CYAN, this.map, new ImageIcon("Files/Player.png"), this, doorsWithMiniGame,loop,mainPlayer);


    }


    /**
     * Updates the game state
     */
    public void update() {


//there will be own gameover
        System.out.println("Game over" + gameOver);
        System.out.println("Win" + win);



    }


}

