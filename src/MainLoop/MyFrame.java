package MainLoop;

import Map.Walls;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    Movement movement = new Movement(this);
    JLabel playerLabel;
    ImageIcon icon;
    JLabel enemyLabel;
    private int widthWindow;
    private int heightWindow;
    Walls walls = new Walls(this);


    public MyFrame() throws HeadlessException {
        widthWindow = 1500;
        heightWindow = 900;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Advanture labirint");
        this.setSize(widthWindow, heightWindow);

        this.addKeyListener(movement);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
//set player size


        setPlayer();
        setEnemy();

        this.add(playerLabel);
        this.add(enemyLabel);

        this.getContentPane().setBackground(Color.BLUE);
        this.setVisible(true);
    }


    public void setPlayer() {
        icon = new ImageIcon("Files/Player.png");
        playerLabel = new JLabel();
        playerLabel.setBounds(0, 0, 40, 40);
        playerLabel.setIcon(icon);
        // jLabel.setBackground(Color.BLACK);
        //jLabel.setOpaque(true);
    }

    public void setEnemy() {
        icon = new ImageIcon("Files/enemy.png");
        enemyLabel = new JLabel();
        enemyLabel.setBounds(widthWindow / 2, heightWindow / 2, 40, 40);
        enemyLabel.setIcon(icon);
    }


}
