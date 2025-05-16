package Minigame;

import Enities.Player;
import MainLoop.MyFrame;
import Map.DoorsWithMiniGame;

public class MinigameLoop implements Runnable {
    private boolean runningMiniGame = true;

    DoorsWithMiniGame doorsWithMiniGame;
    MyFrame myFrame;
    MinigameFrame minigameFrame;
    Player player;

    public MinigameLoop(DoorsWithMiniGame doorsWithMiniGame, MyFrame myFrame, MinigameFrame minigameFrame, Player player) {
        this.doorsWithMiniGame = doorsWithMiniGame;
        this.myFrame = myFrame;
        this.minigameFrame = minigameFrame;
        this.player = player;
    }


    @Override
    public void run() {
        while (runningMiniGame) {

            minigameFrame.repaint();
            minigameFrame.update();
//set if game over then frame game over

            if (minigameFrame.win && !minigameFrame.gameOver) {
                doorsWithMiniGame.setUnlocked(true);
                minigameFrame.dispose();
                runningMiniGame = false;
                player.isSolving = false;
            } else if (minigameFrame.gameOver) {
                doorsWithMiniGame.setUnlocked(false);
                minigameFrame.dispose();
                myFrame.gameOver = true;
                runningMiniGame = false;
                player.isSolving = false;
            }

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
