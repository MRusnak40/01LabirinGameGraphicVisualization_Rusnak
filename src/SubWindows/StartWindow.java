package SubWindows;

import Enities.FollowingPlayer;
import LoadingFromFiles.LoadTextures;
import MainLoop.GameLoop;
import MainLoop.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class StartWindow extends JFrame {
    public boolean isPressedStart = false;
    HelpWindow helpWindow;
    private int choose;
    private Image image;

    public StartWindow() {

        this.setTitle("Start");

        this.setSize(1000, 1050);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon("Files/betterQualityFrameIcon.png");
        setIconImage(imageIcon.getImage());

        getContentPane().setBackground(Color.BLACK);

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

//background
        JLabel imageLabel = new JLabel(LoadTextures.loadImage("Files/backgroundPicture.png"));
        imageLabel.setBounds(0, 0, 1000, 1000);
        add(imageLabel);

        //start button
        JButton startButton = new JButton();
        startButton.setBounds(40, 720, 300, 90);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setOpaque(false);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isPressedStart = true;
                 StartWindow.this.dispose();


              //  StartWindow.this.setVisible(false);
/*
                MyFrame frame = new MyFrame();
                GameLoop loop = new GameLoop(frame);
                FollowingPlayer followingPlayer = new FollowingPlayer(frame, loop);
                Thread thread = new Thread(loop);
                Thread thread2 = new Thread(followingPlayer);

                thread.start();
                thread2.start();

                try {
                    thread.join();
                    thread2.join();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }




 */


                //By chat gpt


                // creat GUI window (MyFrame) must be on EDT=Event Dispatch Thread
                SwingUtilities.invokeLater(() -> {
                    MyFrame frame = new MyFrame(); // GUI window

                    // Vlákna se spustí v samostatném vlákně, ale až po vytvoření GUI
                    new Thread(() -> {

                        GameLoop loop = new GameLoop(frame);
                        FollowingPlayer followingPlayer = new FollowingPlayer(frame, loop);
                        Thread thread1 = new Thread(loop);
                        Thread thread2 = new Thread(followingPlayer);

                        thread1.start();
                        thread2.start();

                        try {
                            thread1.join();
                            thread2.join();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }


                    }).start();
                });




//	↑		↑	↑	↑	↑	↑	↑	↑	↑



            }
        });
        add(startButton);


//mode button

        JButton modeButton = new JButton();
        modeButton.setBounds(740, 710, 240, 90);

        modeButton.setContentAreaFilled(false);
        modeButton.setBorderPainted(false);
        modeButton.setOpaque(false);

        modeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(modeButton);


    }

}
