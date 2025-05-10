package Map;

import Enities.FollowingPlayer;
import MainLoop.GameLoop;
import MainLoop.MyFrame;
import Minigame.MinigameFrame;
import Minigame.MinigameLoop;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;

public class DoorsWithMiniGame extends Doors {
    public DoorsWithMiniGame(boolean isUnlocked) {
        super(isUnlocked);

    }

    MinigameLoop minigameLoop;

    public void miniGame() {
        new Thread(() -> {
            minigameLoop = new MinigameLoop(this);
            Thread thread = new Thread(minigameLoop);
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();


    }



}