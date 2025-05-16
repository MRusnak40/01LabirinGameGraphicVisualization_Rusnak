package Minigame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

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
    Box enemy;
    Map map = new Map();
    DoorsWithMiniGame doorsWithMiniGame;
    MyFrame myFrame;

    public MinigameFrame(DoorsWithMiniGame doorsWithMiniGame, MyFrame myFrame) throws HeadlessException {
        this.doorsWithMiniGame = doorsWithMiniGame;

        this.myFrame = myFrame;
        widthWindow = 1000;
        heightWindow = 1000;

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


    }


    //				 ↑			  ↑					↑


    public void checkColision() {
        if (player.intersects(enemy) || enemy.intersects(player)) {
            gameOver = true;


        } else {
            gameOver = false;


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

        player = new Box(100, 200, 50, 50, Color.CYAN, this.map, new ImageIcon("Files/Player.png"), this, doorsWithMiniGame);

        enemy = new Box(100, 100, 50, 50, Color.RED, this.map, new ImageIcon("Files/enemy.png"), this, doorsWithMiniGame);


    }


    public void update() {

//add here game over from My frame and solving to false

        checkColision();


        //there will be own gameover
    }


}

