package SubWindows;

import javax.swing.*;
import java.awt.event.ActionListener;

public class HelpWindow extends JDialog {
    StartWindow startWindow;
    public int choose;
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
        JTextArea textArea=new JTextArea();

        textArea.setEnabled(false);

        textArea.setText(String.valueOf(text));

    }

}
