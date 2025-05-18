package MainLoop;

import javax.swing.*;

public class GameLoop implements Runnable {

    private MyFrame frame;
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
                //System.out.println(System.currentTimeMillis());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // System.out.println(Thread.currentThread().getName());
        }
    }


    public void restartGame() {

        int result = JOptionPane.showConfirmDialog(frame, "Wanna play again?", "Revive",
                JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {

            frame.gameOver = false;

        }
    }


    }
