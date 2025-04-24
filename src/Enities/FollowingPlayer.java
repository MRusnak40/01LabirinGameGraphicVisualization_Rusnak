package Enities;

import MainLoop.GameLoop;
import MainLoop.MyFrame;

public class FollowingPlayer implements Runnable {

    private int currentx;
    private int currenty;
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
                Thread.sleep(70);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Enemy stoped moving");
    }
}
