package LoadingFromFiles;

import SubTasks.Qestions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadQestions {


    public ArrayList<Qestions> qestionsList(String path) {
        ArrayList<Qestions> qestionsList = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");

                String qestion = split[0];
                String answer = split[1];

                Qestions qestions = new Qestions(qestion, answer);

                qestionsList.add(qestions);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return qestionsList;
    }


}
