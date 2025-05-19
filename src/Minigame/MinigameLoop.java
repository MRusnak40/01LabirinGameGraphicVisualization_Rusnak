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

    /**
     * Constructor for MinigameLoop class that initializes the minigame components
     *
     * @param doorsWithMiniGame The door containing the minigame
     * @param myFrame           The main game frame
     * @param player            The player object
     */
    public MinigameLoop(DoorsWithMiniGame doorsWithMiniGame, MyFrame myFrame, Player player) {
        this.doorsWithMiniGame = doorsWithMiniGame;
        this.myFrame = myFrame;
        this.minigameFrame = new MinigameFrame(doorsWithMiniGame, myFrame, this,player);
        this.player = player;
    }


    /**
     * Main game loop that handles the minigame state and updates
     * Controls win/loss conditions and updates game state
     */
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



    /**
     * Sets the running state of the minigame
     *
     * @param runningMiniGame boolean value to set the minigame's running state
     */
    public void setRunningMiniGame(boolean runningMiniGame) {
        this.runningMiniGame = runningMiniGame;
    }
}
