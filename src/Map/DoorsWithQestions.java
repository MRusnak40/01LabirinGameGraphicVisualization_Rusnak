package Map;

import LoadingFromFiles.LoadQestions;
import SubTasks.Qestions;

import java.util.ArrayList;

public class DoorsWithQestions extends Doors {
    public ArrayList<Qestions> qestions = new ArrayList<>();


    LoadQestions loadQestions = new LoadQestions();


    public DoorsWithQestions(boolean isUnlocked) {
        super(isUnlocked);
        setQestions();

    }

    public void setQestions() {


        qestions = loadQestions.qestionsList("TextFiles/Qestions");


    }




}
