package Map;

import Enities.FollowingPlayer;
import MainLoop.GameLoop;
import MainLoop.MyFrame;
import Minigame.MinigameFrame;
import Minigame.MinigameLoop;

import javax.swing.*;

public class DoorsWithMiniGame extends Doors {
    public DoorsWithMiniGame(boolean isUnlocked) {
        super(isUnlocked);
    }


    public void miniGame() {
        new Thread(() -> {
            MinigameLoop minigameLoop = new MinigameLoop();
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
