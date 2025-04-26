package SubWindows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModeWindow extends JDialog {
    StartWindow startWindow;

    public ModeWindow(StartWindow startWindow) {
        this.startWindow = startWindow;

        this.setTitle("Choose difficulty?");
        this.setSize(300, 200);
        this.setResizable(false);
        this.setLayout(null);
        this.setModal(true);
        this.setLocationRelativeTo(startWindow);

        addComponents();


        this.setVisible(true);

    }


    public void addComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        panel.setBounds(0, 0, getWidth(), getHeight());
        panel.setBackground(new Color(113, 0, 0));

//hard button

        JButton hard = new JButton();
        hard.setBounds(30, 20, 100, 100);
        ImageIcon hardIcon = new ImageIcon("Files/HardButton.png");
        hard.setIcon(hardIcon);
        hard.setContentAreaFilled(false);
        hard.setBorderPainted(false);
        hard.setOpaque(false);

        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

//easy button

        JButton easy = new JButton();
        easy.setBounds(160, 20, 100, 100);
        ImageIcon easyIcon = new ImageIcon("Files/EasyButton.png");
        easy.setIcon(easyIcon);
        easy.setContentAreaFilled(false);
        easy.setBorderPainted(false);
        easy.setOpaque(false);

        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });


        panel.add(hard);
        panel.add(easy);


        //panel.setVisible(true);

        add(panel);

    }
}
