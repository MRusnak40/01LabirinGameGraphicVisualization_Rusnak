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

                if (split.length < 2) {
                    System.err.println("Invalid line (skipping): " + line);
                    continue;
                }

                String qestion = split[0].trim();
                String answer = split[1].trim();

                Qestions qestions = new Qestions(qestion, answer);
                qestionsList.add(qestions);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return qestionsList;
    }


}
