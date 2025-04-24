package SubWindows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindow extends JFrame {
    public boolean isPressedStart = false;
    HelpWindow helpWindow;
    private int choose;

    public StartWindow() {

        this.setTitle("Start");

        this.setSize(1000, 1000);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        ImageIcon imageIcon=new ImageIcon("Files/betterQualityFrameIcon.png");
        setIconImage(imageIcon.getImage());
        Components();
        setVisible(true);
    }


    public void Components() {
        // menu bar on window
        JMenuBar menuBar = new JMenuBar();

//help on menu
        JMenu helpMenu = new JMenu("Help");

//tipes of help
        JMenuItem howToWin = new JMenuItem("How To win");

        howToWin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new HowToWin(StartWindow.this);

            }
        });


        JMenuItem howItWorks = new JMenuItem("How it works");
        howItWorks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new HelpWindow(StartWindow.this);

            }
        });


        helpMenu.add(howToWin);
        helpMenu.add(howItWorks);


        menuBar.add(helpMenu);


        setJMenuBar(menuBar);
    }

}
