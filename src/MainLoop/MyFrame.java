package MainLoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame {
    Movement movement = new Movement(this);
    JLabel jLabel;
    ImageIcon icon;

    public MyFrame() throws HeadlessException {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Advanture labirint");
        this.setSize(1500, 900);
        this.addKeyListener(movement);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        icon = new ImageIcon("Files/pixil-frame-0 (3).png");
        jLabel = new JLabel();
        jLabel.setBounds(0, 0, 40, 40);
        jLabel.setIcon(icon);
        // jLabel.setBackground(Color.BLACK);
        //jLabel.setOpaque(true);


        this.add(jLabel);

this.getContentPane().setBackground(Color.BLUE);
        this.setVisible(true);
    }






}
