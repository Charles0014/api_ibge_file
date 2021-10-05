package br.com.tetra.tech.model;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.input.ReversedLinesFileReader;
import org.springframework.stereotype.Service;

@Service
public class FileManipulation {
	public File writeFile(String log) {
		File arquivo = new File("C://Temp/API_IBGE.txt");

		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(log);
			bw.newLine();
			bw.close();
			fw.close();
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			br.close();
			fr.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return arquivo;
	}

	public List<String> fileReader() throws IOException  {
	  	File arquivo = new File("C://Temp/API_IBGE.txt");
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		List<String> lastLines = new ArrayList<>();
		try (ReversedLinesFileReader reader = new ReversedLinesFileReader(arquivo, 1024, UTF_8)) {
		    String line = "";
		    int contaLine = 0 ;
		    while ((line = reader.readLine()) != null && lastLines.size() < 10) {
		    	contaLine++;
		        lastLines.add(contaLine + " - " + line);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return lastLines;
	}

}
