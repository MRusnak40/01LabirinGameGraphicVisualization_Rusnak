package Tests;

import LoadingFromFiles.LoadText;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;

class LoadTextTest {

    @Test
    void loadsText() throws IOException {
        // Arrange: vytvoř dočasný soubor s testovacím obsahem
        Path tempFile = Files.createTempFile("test", ".txt");
        String expectedContent = "Hello\nWorld";
        Files.writeString(tempFile, expectedContent);

        // Instance třídy s metodou
        LoadText loader = new LoadText();  // Změň podle názvu tvojí třídy

        // Act
        StringBuilder result = loader.loadsText(tempFile.toString());

        // Assert
        String expectedWithLineSeparators = "Hello" + System.lineSeparator() + "World" + System.lineSeparator();
        assertEquals(expectedWithLineSeparators, result.toString());

        // Cleanup
        Files.deleteIfExists(tempFile);
    }
    }
