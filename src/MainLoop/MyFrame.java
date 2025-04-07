package MainLoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener {
    Movement movement = new Movement(this);
    JLabel jLabel;

    public MyFrame() throws HeadlessException {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Advanture labirint");
        this.setSize(1500, 900);
        this.addKeyListener(movement);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);


        jLabel = new JLabel();
        jLabel.setBounds(0, 0, 20, 20);
        jLabel.setBackground(Color.BLACK);

        jLabel.setOpaque(true);
        this.add(jLabel);


        this.setVisible(true);
    }


    @Override
    public void keyTyped(KeyEvent e) {




    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
