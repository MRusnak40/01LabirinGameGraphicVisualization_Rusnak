package Map;

import Enities.FollowingPlayer;
import Enities.Player;
import MainLoop.GameLoop;
import MainLoop.MyFrame;
import Minigame.MinigameFrame;
import Minigame.MinigameLoop;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;

public class DoorsWithMiniGame extends Doors {

    MyFrame myFrame;
Player player;

    public DoorsWithMiniGame(boolean isUnlocked, MyFrame myFrame, Player player) {
        super(isUnlocked);
        this.player=player;
        this.myFrame = myFrame;
    }



    public void miniGame() {

        new Thread(() -> {
            MinigameFrame minigameFrame=new MinigameFrame(this,myFrame);
           MinigameLoop minigameLoop = new MinigameLoop(this, myFrame,minigameFrame,player);
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