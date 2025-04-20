import Enities.FollowingPlayer;
import MainLoop.GameLoop;
import MainLoop.MyFrame;
import PreImplements.Frame;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MyFrame frame = new MyFrame();
        GameLoop loop = new GameLoop(frame);
        FollowingPlayer followingPlayer = new FollowingPlayer(frame,loop);
        Thread thread = new Thread(loop);
        Thread thread2 = new Thread(followingPlayer);

        thread.start();
        thread2.start();

        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //  Frame frame = new Frame();


//do player dat  pohyb zvlast jak v enemy
        //ve frame dat runnable a pustit tam ten pohyb pro enemy kde bude mit cil se dostat na current x y hrace
        //INTERAKCE S DVERMA UDELAME JAKO COLISION DETECTION
    }
}