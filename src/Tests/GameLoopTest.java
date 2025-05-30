package Tests;

import MainLoop.GameLoop;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;
class GameLoopTest {

    @Test
    void testRestartGameSetsGameOverFalseWhenOKClicked() {
        // create anonimous class with revrited method askPlayAgain()

        GameLoop game = new GameLoop(new MainLoop.MyFrame(" ")) {


            // chat gpt ////////////////////////////////////////////
            public int askPlayAgain() {
                return JOptionPane.OK_OPTION; // simulujeme kliknutí na OK
            }

            // //////////////////////////////////////////////
        };

        // set starting point
        game.frame = new MainLoop.MyFrame(" ");
        game.frame.gameOver = true;

        // start tested method
        game.restartGame();

        // check result
        assertFalse(game.frame.gameOver);
    }


}