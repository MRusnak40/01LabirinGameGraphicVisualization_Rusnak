package SubTasks;

import javax.swing.*;
import java.awt.*;

public class MinigameFrame extends JFrame {
    public int widthWindow;
    public int heightWindow;

    public MinigameFrame() {

        widthWindow = 1520;
        heightWindow = 1020;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Mini Game");
        this.setSize(widthWindow, heightWindow);
        this.setBackground(Color.BLACK);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setLayout(null);


        addComponents();


    }


    public void addComponents() {



    }


    public void paint(Graphics g) {


    }


    public void update(){


    }


}
