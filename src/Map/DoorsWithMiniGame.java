package Map;

import Enities.FollowingPlayer;
import MainLoop.GameLoop;
import MainLoop.MyFrame;
import Minigame.MinigameFrame;
import Minigame.MinigameLoop;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;

public class DoorsWithMiniGame extends Doors {

    MyFrame myFrame;

    public DoorsWithMiniGame(boolean isUnlocked, MyFrame myFrame) {
        super(isUnlocked);
        this.myFrame = myFrame;
    }

    MinigameLoop minigameLoop;

    public void miniGame() {

        new Thread(() -> {
            minigameLoop = new MinigameLoop(this,myFrame);
            Thread thread5 = new Thread(minigameLoop);
            thread5.setName("MiniGame_Thread");

            thread5.start();

            try {
                thread5.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();


    }


}