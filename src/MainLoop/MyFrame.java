package MainLoop;

import Enities.Enemy;
import Enities.Player;
import Map.Walls;
import PreImplements.Box;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class MyFrame extends JFrame {

    Movement movement = new Movement(this);
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
    Image images;
    BufferedImage bufferedImage;


    public MyFrame() throws HeadlessException {


        widthWindow = 1520;
        heightWindow = 1000;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Advanture labirint");
        this.setSize(widthWindow, heightWindow);

        createPlayers();



        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
//set player size


        walls.setPreferredSize(new Dimension(widthWindow, heightWindow));

        this.setLayout(new BorderLayout());
        walls.setPreferredSize(new Dimension(widthWindow, heightWindow));
        this.add(walls, BorderLayout.CENTER);

        this.addKeyListener(new Al());
        this.getContentPane().setBackground(Color.BLUE);
        this.setVisible(true);
    }





    /*
    public void update(Graphics g) {
        paint(g); // zabraňuje blikání tím, že nečistí pozadí
    }



    public void paint(Graphics g) {
        bufferedImage = new BufferedImage(widthWindow, heightWindow, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bufferedImage.createGraphics();

        image = createImage(this.getWidth(), this.getHeight());
        graphics = image.getGraphics();


        //g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);

        g2.drawImage(bufferedImage, 0, 0, this); // zobrazíme vykreslený obraz


        player.draw(g);
        enemy.draw(g);


        if (gameOver == true) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 100));
            g.drawString("Game Over", 100, 200);
        }
        g.dispose();

    }


     */


    @Override
    public void paint(Graphics g) {
        // Vytvoření off-screen bufferu (pouze JEDNOU, ne pokaždé v paint)
        if (bufferedImage == null) {
            bufferedImage = new BufferedImage(widthWindow, heightWindow, BufferedImage.TYPE_INT_ARGB);
        }

        Graphics2D g2 = bufferedImage.createGraphics();

        // Vyčisti pozadí
        g2.setColor(getBackground());
        g2.fillRect(0, 0, getWidth(), getHeight());

        // Vykresli herní objekty
        walls.paint(g2);
        player.draw(g2);
        enemy.draw(g2);

        // Game over text
        if (gameOver) {
            g2.setColor(Color.RED);
            g2.setFont(new Font("Arial", Font.BOLD, 100));
            g2.drawString("Game Over", 100, 200);
        }


        // Přenes obraz z bufferu na obrazovku
        g.drawImage(bufferedImage, 0, 0, this);

        g2.dispose(); // ukončíme práci s g2, ne s g!
    }


    public boolean checkColision() {
        if (player.intersects(enemy)) {


            return true;

        }
        return false;
    }


    public class Al extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
            gameOver = checkColision();
            System.out.println(player.getX()+" "+player.getY());
            repaint();

        }
    }


    public void createPlayers() {
        player = new Player(1250, 930, 20, 20, Color.CYAN, icon);
        enemy = new Enemy(1450, 930, 20, 20, Color.RED);


    }

}
