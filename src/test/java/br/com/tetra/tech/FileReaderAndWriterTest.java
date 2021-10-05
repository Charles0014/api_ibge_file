package br.com.tetra.tech;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.input.ReversedLinesFileReader;
import org.junit.jupiter.api.Test;

public class FileReaderAndWriterTest {
	
    @Test
    public void testReadLastFiveLines() {
    	File arquivo = new File("C://Temp/API_IBGE.txt");
        List<String> lastLines = new ArrayList<>();
        try (ReversedLinesFileReader reader = new ReversedLinesFileReader(arquivo, 1024, UTF_8)) {
            String line = "";
            while ((line = reader.readLine()) != null && lastLines.size() < 10) {
                lastLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ultimas 10 linhas -- Test");
        for(String l: lastLines) {
            System.out.println(l);
        }

        assertEquals(10, lastLines.size());
    }
}
