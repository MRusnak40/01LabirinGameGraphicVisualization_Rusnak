package MainLoop;

import javax.swing.*;

public class GameLoop implements Runnable {

    public MyFrame frame;
    public boolean running;


    public GameLoop(MyFrame frame) {
        this.frame = frame;
        this.running = true;
    }


    @Override
    public void run() {

        while (running) {


// Update game state
            frame.update();


            // Render the game
            frame.repaint();

            //if player touched enemy
            if (frame.gameOver) {

                restartGame();

            }
            System.out.println(Thread.currentThread().getName());
            // Sleep for a short duration to control the loop speed
            try {
                Thread.sleep(16); // Roughly 60 FPS

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void restartGame() {

        int result = JOptionPane.showConfirmDialog(frame, "Wanna play again?", "Revive",
                JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {

            frame.gameOver = false;

        }
    }

    public MyFrame getFrame() {
        return frame;
    }

    public void setFrame(MyFrame frame) {
        this.frame = frame;
    }

    public boolean isRunning() {
        return running;
    }



}
