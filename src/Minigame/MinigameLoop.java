package Minigame;

import Map.DoorsWithMiniGame;

public class MinigameLoop implements Runnable {
    private boolean running = true;
    
DoorsWithMiniGame doorsWithMiniGame;

    public MinigameLoop(DoorsWithMiniGame doorsWithMiniGame) {
        this.doorsWithMiniGame = doorsWithMiniGame;
    }

    MinigameFrame frame = new MinigameFrame(doorsWithMiniGame);


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

        }
    }


}
