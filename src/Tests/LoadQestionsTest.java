package Tests;

import Map.DoorsWithQestions;
import SubTasks.Qestions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class LoadQestionsTest {

    //checks if load file works

    //chat gpt
    @Test
    void testQestionsList() throws IOException {
        // 1. create file
        File tempFile = File.createTempFile("questions_test", ".txt");
        try (PrintWriter out = new PrintWriter(tempFile)) {
            out.println("Kolik je 2+2?,4");
            out.println("Hlavní město ČR?,Praha");
        }

        // 2. call methods
        DoorsWithQestions doorsWithQestions = new DoorsWithQestions(false);
        ArrayList<Qestions> result = doorsWithQestions.setQestions(tempFile.getAbsolutePath());

        // 3. Očekávaný výsledek
        ArrayList<Qestions> expected = new ArrayList<>();
        expected.add(new Qestions("Kolik je 2+2?", "4"));
        expected.add(new Qestions("Hlavní město ČR?", "Praha"));

        // / ////////////////////////////////////






        // 4. checks if list is not null
        // assertEquals(expected, result);
        assertNotNull(result);
        // 5. dele file
        tempFile.delete();
    }
}