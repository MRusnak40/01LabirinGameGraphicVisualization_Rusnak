package MainLoop;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener {
    MyFrame frame;

    @Override
    public void keyTyped(KeyEvent e) {


        switch (e.getKeyChar()) {


            case 'w':
                frame.jLabel.setLocation(frame.jLabel.getX(), frame.jLabel.getY() - 10);
                break;
            case 's':
                frame.jLabel.setLocation(frame.jLabel.getX(), frame.jLabel.getY() + 10);
                break;
            case 'd':
                frame.jLabel.setLocation(frame.jLabel.getX() + 10, frame.jLabel.getY());
                break;

            case 'a':
                frame.jLabel.setLocation(frame.jLabel.getX() - 10, frame.jLabel.getY());
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
        System.out.println("Key released:" + e.getKeyChar());
        System.out.println("Key released:" + e.getKeyCode());
    }


}
