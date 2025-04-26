package SubWindows;

import LoadingFromFiles.LoadText;

import javax.swing.*;
import java.awt.*;

public class HowToWin extends JDialog {

    StartWindow startWindow;
    public StringBuilder text = new StringBuilder();
    LoadText loadText = new LoadText();

    public HowToWin(StartWindow startWindow) {
        this.startWindow = startWindow;

        //sets window
        setTitle("Winning position");
        setSize(500, 500);
        setResizable(false);
        setLayout(null);
        setModal(true);
        setLocationRelativeTo(startWindow);

        addComponent();


        setVisible(true);
    }


    public void addComponent() {

//sets text
        JTextArea textArea = new JTextArea();

        textArea.setEnabled(false);

        text = loadText.loadsText("TextFiles/HowToPlay");

        textArea.setText(text.toString());

        textArea.setFont(new Font("Arial", Font.PLAIN, 20));


        textArea.setBackground(new Color(88, 17, 105));
        textArea.setForeground(new Color(31, 10, 144));
        textArea.setBounds(10, 10, 460, 440);


//sets picture to how to play

        //finish
        JLabel imageLabel = new JLabel();

        imageLabel.setBounds(400, 20, 40, 40);
        ImageIcon imageIcon = new ImageIcon("Files/finish.png");
        imageLabel.setIcon(imageIcon);


        add(imageLabel);



//player
        imageLabel=new JLabel();



        imageLabel.setBounds(400, 100, 40, 40);
        imageIcon = new ImageIcon("Files/Player.png");
        imageLabel.setIcon(imageIcon);


        add(imageLabel);

        //enemy
        imageLabel=new JLabel();



        imageLabel.setBounds(400, 200, 40, 40);
        imageIcon = new ImageIcon("Files/enemy.png");
        imageLabel.setIcon(imageIcon);


        add(imageLabel);




//add text
        add(textArea);
    }
}
