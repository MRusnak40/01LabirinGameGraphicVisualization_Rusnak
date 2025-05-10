package Minigame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import Map.Walls;
import Map.DoorsWithMiniGame;

public class MinigameFrame extends JFrame {
    Image image;
    Graphics graphics;
    private int widthWindow;
    private int heightWindow;
    private String name;
    BufferedImage bufferedImage;
    Graphics2D g2;
    boolean win = false;
    boolean gameOver = false;
    Box player;
    Box enemy;
    ImageIcon icon = new ImageIcon("Files/playerIcon.png");
    Map map = new Map();
    DoorsWithMiniGame doorsWithMiniGame;

    public MinigameFrame(DoorsWithMiniGame doorsWithMiniGame) throws HeadlessException {
        this.doorsWithMiniGame = doorsWithMiniGame;
        this.gameOver = gameOver;
        widthWindow = 1000;
        heightWindow = 1000;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Advanture labirint");
        this.setSize(widthWindow, heightWindow);

        createPlayers();

        this.setBackground(Color.BLACK);

        //this.setLayout(null);

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

    public void createWalls() {
        map.setPreferredSize(new Dimension(widthWindow, heightWindow));
        this.add(map, BorderLayout.CENTER);
    }

    //By chat gpt

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
        enemy.draw(g2);

        endText();


        // Přenes obraz z bufferu na obrazovku
        g.drawImage(bufferedImage, 0, 0, this);

        g2.dispose(); // ukončíme práci s g2, ne s g!
    }

    public void endText() {
        // Game over text
        if (gameOver) {

            g2.setColor(Color.BLACK);
            g2.setFont(new Font("Arial", Font.BOLD, 140));
            g2.drawString("Died", 50, 400);

        } else if (win && !gameOver) {

            g2.setColor(Color.BLACK);
            g2.setFont(new Font("Arial", Font.BOLD, 140));
            g2.drawString("Won", 50, 400);


        }
    }


    //				 ↑			  ↑					↑


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


    private class Al extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);

            checkColision();

            repaint();

        }
    }


    public void createPlayers() {


//x 1250 y 930
        //y,x= 100

        player = new Box(100, 200, 50, 50, Color.CYAN, this.map, new ImageIcon("Files/Player.png"));

        enemy = new Box(100, 100, 50, 50, Color.RED, this.map, new ImageIcon("Files/enemy.png"));


    }


    public void update() {

        // Update game logic here

        // Update player logic

        // enemy.update();
        //gameOver = checkColision();


        // Update enemy logic
        // Check for collisions

        //System.out.println(player.listOfTracks.size());

        if (gameOver) {


            JOptionPane.showMessageDialog(null, "Game over");
            Thread.interrupted();
            dispose();
            doorsWithMiniGame.setUnlocked(false);
            gameOver = false;

        } else if (win && !gameOver) {
            JOptionPane.showMessageDialog(null, "Win");
            Thread.interrupted();
            dispose();
            doorsWithMiniGame.setUnlocked(true);
            win = false;

        }


    }


}

