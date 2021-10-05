package br.com.tetra.tech.model;

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

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class FileManipulation {
	public File writeFile(DadosIbge dados) {
		File arquivo = new File("C://Temp/API_IBGE.txt");

		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Localidade:" + dados.getLocalidade() + " Hora: " + dados.getHorario() + " População: "
					+ dados.getProjecao().getPopulacao() + " Crescimento: "
					+ dados.getProjecao().getPeriodoMedio().getIncrementoPopulacional());
			bw.newLine();
			bw.close();
			fw.close();
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {
				String linha = br.readLine();
				System.out.println(linha);
			}
			br.close();
			fr.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return arquivo;
	}

	public List<String> fileReader(File file)  {
		List<String> lastLines = new ArrayList<>();
		try (ReversedLinesFileReader reader = new ReversedLinesFileReader(file, 1024, UTF_8)) {
		    String line = "";
		    while ((line = reader.readLine()) != null && lastLines.size() < 10) {
		        lastLines.add(line);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return lastLines;
	}

}
