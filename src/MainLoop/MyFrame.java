package MainLoop;

import Enities.Enemy;
import Enities.Player;
import Map.Doors;
import Map.Walls;
import PreImplements.Box;

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
    public boolean gameOver=false;
    Image images;
    BufferedImage bufferedImage;
    Graphics2D g2;

    public MyFrame() throws HeadlessException {

        this.gameOver=gameOver;
        widthWindow = 1520;
        heightWindow = 1020;
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
//

        walls.setPreferredSize(new Dimension(widthWindow, heightWindow));


        this.addKeyListener(new Al());
        this.getContentPane().setBackground(Color.BLUE);

        ImageIcon imageIcon = new ImageIcon("Files/betterQualityFrameIcon.png");
        setIconImage(imageIcon.getImage());


        this.add(walls, BorderLayout.CENTER);

        this.setVisible(true);


    }





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
        walls.paint(g2);
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
            g2.setColor(Color.RED);
            g2.setFont(new Font("Arial", Font.BOLD, 250));
            g2.drawString("Game Over", 100, 800);

        }
    }


    public void checkColision() {
        if (player.intersects(enemy)) {
            gameOver = true;
            System.out.println("Colision");
        } else if (enemy.intersects(player)) {
            System.out.println("Colision");
            gameOver = true;
        } else {
            gameOver = false;
        }


    }


    public class Al extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);

            checkColision();

            repaint();

        }
    }


    public void createPlayers() {
        player = new Player(1250, 930, 20, 20, Color.CYAN, icon, walls, this,"Jiri");

        enemy = new Enemy(1450, 930, 20, 20, Color.RED, this.player, this);


    }

    public void updateEnemies() {
        enemy.update();
    }

    public void update() {

        // Update game logic here

        player.update(); // Update player logic

        // enemy.update();
        //gameOver = checkColision();


        // Update enemy logic
        // Check for collisions

        //System.out.println(player.listOfTracks.size());
    }

    public String setName(){

        return " ";
    }

}
