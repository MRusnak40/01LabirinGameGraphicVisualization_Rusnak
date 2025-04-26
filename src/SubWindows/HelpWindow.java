package SubWindows;

import LoadingFromFiles.LoadText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HelpWindow extends JDialog {
    StartWindow startWindow;
    public int choose;
    LoadText loadText = new LoadText();
    StringBuilder text=new StringBuilder();
    public HelpWindow(StartWindow startWindow) {
        this.startWindow = startWindow;

        setTitle("Rules");
        setSize(500, 500);
        setResizable(false);
        setLayout(null);
        setModal(true);
        setLocationRelativeTo(startWindow);

        addComponent();

        setVisible(true);
    }


    public void addComponent() {

        JTextArea textArea = new JTextArea();

        textArea.setEnabled(false);

        text=loadText.loadsText("TextFiles/Help");

        textArea.setText(text.toString());

        textArea.setFont(new Font("Arial", Font.PLAIN, 20));


        textArea.setBackground(new Color(88, 17, 105));
        textArea.setForeground(new Color(31, 10, 144));
        textArea.setBounds(10, 10, 460, 440);

        add(textArea);
    }

}
