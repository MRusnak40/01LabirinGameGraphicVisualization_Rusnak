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

    public MinigameLoop(DoorsWithMiniGame doorsWithMiniGame, MyFrame myFrame, Player player) {
        this.doorsWithMiniGame = doorsWithMiniGame;
        this.myFrame = myFrame;
        this.minigameFrame = new MinigameFrame(doorsWithMiniGame, myFrame, this,player);
        this.player = player;
    }


    @Override
    public void run() {
        while (runningMiniGame) {

            minigameFrame.update();
            minigameFrame.repaint();

//set if game over then frame game over

            if (minigameFrame.win && !minigameFrame.gameOver) {
                doorsWithMiniGame.setUnlocked(true);

                player.maze[player.rowCurrnet][player.colCurrent] = 0;
                minigameFrame.dispose();

                runningMiniGame = false;
                player.isSolving = false;
            } else if (minigameFrame.gameOver) {
                doorsWithMiniGame.setUnlocked(false);
                minigameFrame.dispose();
                myFrame.gameOver = true;
                runningMiniGame = false;
                player.isSolving = false;
            } else {
                doorsWithMiniGame.setUnlocked(false);

                myFrame.gameOver = true;
                runningMiniGame = false;
                player.isSolving = false;
                minigameFrame.dispose();


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

    public boolean isRunningMiniGame() {
        return runningMiniGame;
    }

    public void setRunningMiniGame(boolean runningMiniGame) {
        this.runningMiniGame = runningMiniGame;
    }
}
