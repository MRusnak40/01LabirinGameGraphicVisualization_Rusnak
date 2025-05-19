package Enities;

import MainLoop.GameLoop;
import MainLoop.MyFrame;

public class FollowingPlayer implements Runnable {

    private int currentx;
    private int setsDifficulty = 100;
    MyFrame frame;
    GameLoop gameLoop;

    /**
     * Constructor for the FollowingPlayer class
     *
     * @param frame The game frame instance
     * @param gameLoop The game loop instance
     * @param setsDifficulty The difficulty setting that affects enemy movement speed
     */
    public FollowingPlayer(MyFrame frame, GameLoop gameLoop, int setsDifficulty) {
        this.frame = frame;
        this.gameLoop = gameLoop;
        this.setsDifficulty = setsDifficulty;
    }

    /**
     * Runs the enemy movement loop. Updates enemy positions while the game is running
     * and not in game over state. Controls the movement speed through sleep duration.
     */
    @Override
    public void run() {
        ;
        while (gameLoop.running) {
            if (!frame.gameOver) {
                frame.updateEnemies();
                // System.out.println(Thread.currentThread().getName());

                System.out.println(Thread.currentThread().getName());


            }
            try {  //mills is playble 70
                //62 hard
                //80 easy
                Thread.sleep(setsDifficulty);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Enemy stoped moving " + gameLoop.running + " frame game over " + frame.gameOver + " " + Thread.currentThread().getName());
        }

    }


    public int getSetsDifficulty() {
        return setsDifficulty;
    }


    public void setSetsDifficulty(int setsDifficulty) {
        this.setsDifficulty = setsDifficulty;
    }
}
