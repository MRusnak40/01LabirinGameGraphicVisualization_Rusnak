package Map;

import javax.swing.*;
import java.util.Random;

public class DoorsWithMath extends Doors {
    public DoorsWithMath(boolean isUnlocked) {
        super(isUnlocked);
    }

    Random rand = new Random();
    int number1;
    int number2;
    int number3;
    int number4 = 0;
    int answeros = 0;
    String action;

    public void mathTask(int number3) {


        switch (number3) {

            case 0:

                number4 = number1 + number2;
                action = "+";
                break;

            case 1:

                number4 = number1 - number2;
                action = "-";
                break;

            case 2:

                number4 = number1 * number2;
                action = "*";
                break;

        }


    }

    public boolean showMathTask() {

        number3 = rand.nextInt(3);
        number2 = rand.nextInt(10);
        number1 = rand.nextInt(10);

        mathTask(number3);

        try {
            answeros = Integer.parseInt(JOptionPane.showInputDialog("how much is " + number1 + action + number2));

        } catch (NumberFormatException e) {
            return false;
        }
        if (answeros == number4) {

            return true;
        } else {
            return false;
        }

    }


}
