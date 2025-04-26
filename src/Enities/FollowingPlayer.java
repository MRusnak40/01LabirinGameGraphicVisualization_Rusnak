package Enities;

import MainLoop.GameLoop;
import MainLoop.MyFrame;

public class FollowingPlayer implements Runnable {

    private int currentx;
    private int setsDifficulty=100;
    MyFrame frame;
GameLoop gameLoop;

    public FollowingPlayer(MyFrame frame,GameLoop gameLoop) {
        this.frame = frame;
        this.gameLoop= gameLoop;
    }

    @Override
    public void run() {
        while(gameLoop.running) {
            frame.updateEnemies();
           // System.out.println(Thread.currentThread().getName());


            try {
                Thread.sleep(setsDifficulty);
                //mills is playble 70
                //62 hard
                //80 easy

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Enemy stoped moving");
    }

    public int getSetsDifficulty() {
        return setsDifficulty;
    }

    public void setSetsDifficulty(int setsDifficulty) {
        this.setsDifficulty = setsDifficulty;
    }
}
