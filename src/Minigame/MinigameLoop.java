package Minigame;

import MainLoop.MyFrame;
import Map.DoorsWithMiniGame;

public class MinigameLoop implements Runnable {
    private boolean running = true;

    DoorsWithMiniGame doorsWithMiniGame;
    MyFrame myFrame;

    public MinigameLoop(DoorsWithMiniGame doorsWithMiniGame, MyFrame myFrame) {
        this.doorsWithMiniGame = doorsWithMiniGame;
        this.myFrame = myFrame;
    }

    MinigameFrame frame = new MinigameFrame(doorsWithMiniGame,myFrame);


    @Override
    public void run() {
        while (running) {

            frame.repaint();
            frame.update();


            // Sleep for a short duration to control the loop speed
            try {
                Thread.sleep(16); // Roughly 60 FPS
                //System.out.println(System.currentTimeMillis());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(">" + Thread.currentThread().getName() + " Enemy thread");
        }
    }


}
