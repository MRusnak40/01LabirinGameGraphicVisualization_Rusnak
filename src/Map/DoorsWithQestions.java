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


    /**
     * Constructor for DoorsWithQestions class
     *
     * @param isUnlocked boolean parameter determining if the door is unlocked
     */
    public DoorsWithQestions(boolean isUnlocked) {
        super(isUnlocked);
        setQestions("TextFiles/Qestions");

    }

    /**
     * Loads questions from specified file path
     *
     * @param path String representing the file path where questions are stored
     * @return ArrayList of Qestions objects loaded from the file
     */
    public ArrayList<Qestions> setQestions(String path) {


        qestions = loadQestions.qestionsList(path);


        return qestions;
    }

    /**
     * Handles the question and answer process
     *
     * @return boolean indicating if the answer was correct (true) or incorrect (false)
     */
    public boolean answer() {


        int qestion = rd.nextInt(qestions.size());

        JOptionPane.showMessageDialog(null, qestions.get(qestion).getQestion(), "Doors", JOptionPane.INFORMATION_MESSAGE);

        String answer = JOptionPane.showInputDialog("Add your answer");
        if (answer != null) {
            answer = answer.toLowerCase();
        } else {
            answer = " ";
        }
        if (answer.equals(qestions.get(qestion).getGoodAnswer())) {
            System.out.println(qestion);
            return true;
        }
        System.out.println(qestion);
        return false;
    }


}
