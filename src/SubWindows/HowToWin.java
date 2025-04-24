package SubWindows;

import javax.swing.*;
import java.awt.event.ActionListener;

public class HowToWin extends JDialog {

    StartWindow startWindow;
StringBuilder text=new StringBuilder();

    public HowToWin(StartWindow startWindow) {
        this.startWindow = startWindow;

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
JTextArea textArea=new JTextArea();

textArea.setEnabled(false);

textArea.setText(String.valueOf(text));
    }
}
