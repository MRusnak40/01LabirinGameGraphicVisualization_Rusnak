package LoadingFromFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadText {

    StringBuilder text=new StringBuilder();




public  StringBuilder loadsText(String path) {

    StringBuilder text = new StringBuilder();

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        String line;
        while ((line = br.readLine()) != null) {
            //reads  line and sets next line
            text.append(line).append(System.lineSeparator());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return text;
}

}
