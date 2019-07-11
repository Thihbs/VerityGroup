package utils.readers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import utils.exceptions.ExceptionUtils;

public class TxtReader {

	/**
	 * Este método retorna uma lista de strings de um arquivo .txt
	 * 
	 * @author Fábio Vaz
	 * @since 27/09/2018
	 */
	public static List<String> fileInLines(String pathFile) {

		Path path = Paths.get(pathFile);

		List<String> linhasArquivo = null;

		try {
			linhasArquivo = Files.readAllLines(path);
		} catch (Exception exception) {
			ExceptionUtils.throwException(exception);
		}

		return linhasArquivo;
	}

	/**
	 * Este método retorna uma string com todos caracteres de um arquivo .txt
	 * 
	 * @author Fábio Vaz
	 * @since 27/09/2018
	 */
	public static String fileInLine(String pathFile) {

		List<String> linhasArquivo = fileInLines(pathFile);

		StringBuilder stringBuilder = new StringBuilder();

		for (String linha : linhasArquivo) {
			stringBuilder.append(linha + " ");
		}

		return stringBuilder.toString();
	}

}
