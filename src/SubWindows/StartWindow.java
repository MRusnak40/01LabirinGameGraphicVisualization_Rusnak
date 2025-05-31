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
    private int chooseOfMode;
    private Image image;
    private String name;
    public boolean isPressedMode = false;
    private int modes = 0;

    /**
     * Constructor for the StartWindow class.
     * Initializes the main start window with basic settings and components.
     */
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


    /**
     * Initializes and adds all GUI components to the start window.
     * Creates menu bar, help menu, buttons and background image.
     */
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

//menu on top window
        JMenuItem howItWorks = new JMenuItem("How it works");
        howItWorks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new HelpWindow(StartWindow.this);

            }
        });

//adding
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

                if (isPressedMode && modes != 0) {
                    isPressedStart = true;

                    name = JOptionPane.showInputDialog("Set name to your character");
                    StartWindow.this.dispose();








                    //By chat gpt





                    // creat GUI window (MyFrame) must be on EDT=Event Dispatch Thread
                    SwingUtilities.invokeLater(() -> {
                        MyFrame frame = new MyFrame(name); // GUI window

                        // Vlákna se spustí v samostatném vlákně, ale až po vytvoření GUI
                        //it will be easier for gui because gui can freeze if i wlii do some activities in action listener
                        new Thread(() -> {

                            GameLoop loop = new GameLoop(frame);


                            System.out.println(modes);

                            FollowingPlayer followingPlayer = new FollowingPlayer(frame, loop, modes);
                            Thread thread1 = new Thread(loop);
                            Thread thread2 = new Thread(followingPlayer);

                            thread1.setName("GameLoop_Thread");
                            thread2.setName("FollowingPlayer_Thread");

                            thread1.start();
                            thread2.start();

/*
                            try {
                                thread1.join();
                                thread2.join();
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }


 */

                        }).start();
                    });



//	↑		↑	↑	↑	↑	↑	↑	↑	↑






                }

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

                ModeWindow modeWindow = new ModeWindow(StartWindow.this);


                isPressedMode = true;

            }
        });


        add(modeButton);


    }

    /**
     * Gets the player's name.
     *
     * @return The name of the player
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the player's name.
     *
     * @param name The name to set for the player
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }





    /**
     * Sets the game modes setting.
     *
     * @param modes The modes value to set
     */
    public void setModes(int modes) {
        this.modes = modes;
    }
}
