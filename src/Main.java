import LoadingFromFiles.LoadText;
import SubWindows.StartWindow;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LoadText loadText = new LoadText();


        // Spuštění GUI musí být v Event Dispatch Thread (Swing best practice)
        SwingUtilities.invokeLater(() -> {
            new StartWindow();
        });
    }








/* StartWindow startWindow= new StartWindow();
            MyFrame frame = new MyFrame();
            GameLoop loop = new GameLoop(frame);
            FollowingPlayer followingPlayer = new FollowingPlayer(frame, loop);
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


 */

        //  Frame frame = new Frame();

//mode on easy set on 8000
//do player dat  pohyb zvlast jak v enemy
        //ve frame dat runnable a pustit tam ten pohyb pro enemy kde bude mit cil se dostat na current x y hrace
        //INTERAKCE S DVERMA UDELAME JAKO COLISION DETECTION

}