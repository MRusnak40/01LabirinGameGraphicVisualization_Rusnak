import LoadingFromFiles.LoadText;
import Map.DoorsWithMiniGame;
import SubWindows.StartWindow;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LoadText loadText = new LoadText();


        // turn on GUI must be in Event Dispatch Thread (Swing best practice)
        SwingUtilities.invokeLater(() -> {
          new StartWindow();
        });
    }


//mode on easy set on 8000
    //do not restart all map on death
//do player dat  pohyb zvlast jak v enemy
        //ve frame dat runnable a pustit tam ten pohyb pro enemy kde bude mit cil se dostat na current x y hrace
        //INTERAKCE S DVERMA UDELAME JAKO COLISION DETECTION

}