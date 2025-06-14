package MainLoop;

import Enities.Enemy;
import Enities.Player;
import Map.Doors;
import Map.Walls;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;

public class MyFrame extends JFrame {
    private GameLoop gameLoop;

    JLabel playerLabel;
    ImageIcon icon;
    Image image;
    Graphics graphics;
    private int widthWindow;
    private int heightWindow;
    Walls walls = new Walls();
    Player player;
    Enemy enemy;
    public boolean gameOver = false;
    private String name;
    Image images;
    BufferedImage bufferedImage;
    Graphics2D g2;

    public MyFrame(String name) throws HeadlessException {
        setName(name);
        this.gameOver = gameOver;
        widthWindow = 1520;
        heightWindow = 1020;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Advanture labirint");
        this.setSize(widthWindow, heightWindow);


        this.setBackground(Color.BLACK);

        //this.setLayout(null);

        this.setResizable(false);
        this.setLocationRelativeTo(null);
//set player size


        //walls.setPreferredSize(new Dimension(widthWindow, heightWindow));

        this.setLayout(new BorderLayout());
//


        createWalls();

        this.addKeyListener(new Al());
        this.getContentPane().setBackground(Color.BLUE);

        ImageIcon imageIcon = new ImageIcon("Files/betterQualityFrameIcon.png");
        setIconImage(imageIcon.getImage());

        createPlayers();

        this.setVisible(true);


    }

    //building walls

    /**
     * Creates and initializes walls in the game window.
     * Sets preferred size for walls and adds them to the frame.
     */
    public void createWalls() {
        walls.setPreferredSize(new Dimension(widthWindow, heightWindow));
        this.add(walls, BorderLayout.CENTER);
    }


    //By chat gpt

    @Override
    /**
     * Paints all game components using double buffering technique.
     * @param g Graphics context to paint on
     */
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
        walls.paint(g2);
        player.draw(g2);
        enemy.draw(g2);

        endText();


        // Přenes obraz z bufferu na obrazovku
        g.drawImage(bufferedImage, 0, 0, this);

        g2.dispose(); // ukončíme práci s g2, ne s g!
    }

    /**
     * Draws game over text when the game ends.
     * Text is drawn in red color if gameOver flag is true.
     */
    public void endText() {
        // Game over text
        if (gameOver) {
            g2.setColor(Color.RED);
            g2.setFont(new Font("Arial", Font.BOLD, 250));
            g2.drawString("Game Over", 100, 400);

        }
    }


    //				 ↑			  ↑					↑


    /**
     * Checks for collisions between player and enemy.
     * Sets gameOver flag to true if collision is detected.
     */
    public void checkColision() {
        if (player.intersects(enemy)) {
            gameOver = true;
            System.out.println("Colision");
        } else if (enemy.intersects(player)) {
            System.out.println("Colision");
            gameOver = true;
        } else {
            //  gameOver = false;
        }


    }


    /**
     * Inner class handling keyboard input events.
     * Updates player position and checks for collisions on key press.
     */
    public class Al extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);

            checkColision();

            repaint();

        }
    }


    /**
     * Initializes player and enemy objects with their starting positions and properties.
     */
    public void createPlayers() {
//x 1250 y 930
        //y,x= 100
        player = new Player(1250, 930, 20, 20, Color.CYAN, icon, walls, this, name, walls);

        enemy = new Enemy(1450, 930, 20, 20, Color.RED, this.player, this);


    }

    /**
     * Updates the state of enemy objects.
     * Currently only updates single enemy instance.
     */
    public void updateEnemies() {
        enemy.update();
    }

    /**
     * Updates game state including player position and checks game over condition.
     * Resets players if game is over.
     */
    public void update() {


// Update player logic
        player.update();

        // Update game logic here

        if (gameOver) {


            createPlayers();


        }


    }

    /**
     * Sets the name for the frame.
     *
     * @param nameos Name to be set, if null empty string is used
     */
    public void setName(String nameos) {
        if (nameos != null) {

            this.name = nameos;
        } else {
            this.name = " ";
        }
    }

    @Override

    public String getName() {
        return name;
    }


}
