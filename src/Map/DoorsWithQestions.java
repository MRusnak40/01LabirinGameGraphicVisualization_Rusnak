package Map;

import LoadingFromFiles.LoadQestions;
import SubTasks.Qestions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class DoorsWithQestions extends Doors {
    public ArrayList<Qestions> qestions = new ArrayList<>();
    Random rd = new Random();

    LoadQestions loadQestions = new LoadQestions();


    public DoorsWithQestions(boolean isUnlocked) {
        super(isUnlocked);
        setQestions();

    }

    public void setQestions() {


        qestions = loadQestions.qestionsList("TextFiles/Qestions");


    }

    public boolean answer() {


        int qestion = rd.nextInt(qestions.size());

        JOptionPane.showMessageDialog(null, qestions.get(rd.nextInt(qestion)).getQestion(), "Doors", JOptionPane.INFORMATION_MESSAGE);

        String answer = JOptionPane.showInputDialog("Add your answer");
        if (answer != null) {
            answer = answer.toLowerCase();
        } else {
            answer = " ";
        }
        if (answer.equals(qestions.get(rd.nextInt(qestion)).getGoodAnswer())) {
            System.out.println(qestion);
            return true;
        }
        System.out.println(qestion);
        return false;
    }


}
