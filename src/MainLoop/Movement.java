package MainLoop;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener {
    MyFrame frame;
private int currentx;
private int currenty;
    @Override
    public void keyTyped(KeyEvent e) {


        switch (e.getKeyChar()) {


            case 'w':
                frame.playerLabel.setLocation(frame.playerLabel.getX(), frame.playerLabel.getY() - 10);
                break;
            case 's':
                frame.playerLabel.setLocation(frame.playerLabel.getX(), frame.playerLabel.getY() + 10);
                break;
            case 'd':
                frame.playerLabel.setLocation(frame.playerLabel.getX() + 10, frame.playerLabel.getY());
                break;

            case 'a':
                frame.playerLabel.setLocation(frame.playerLabel.getX() - 10, frame.playerLabel.getY());
                break;

        }

    }

    public Movement(MyFrame frame) {
        this.frame = frame;
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        /*
        System.out.println("Key released:" + e.getKeyChar());
        System.out.println("Key released:" + e.getKeyCode());

         */
    }


}
