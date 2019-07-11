package utils.readers;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;

public class SearchFile {

	/**
	 * Este método procura sozinho e retorna o path de um arquivo .sql apenas
	 * passando o nome do mesmo
	 * 
	 * @author Fábio Vaz
	 * @since 27/09/2018
	 */
	public static String getAbsolutePath(String fileName) {

		File root = new File("./src/");

		String[] extensions = { "sql" };
		boolean isRecursive = true;

		Collection<?> files = FileUtils.listFiles(root, extensions, isRecursive);

		String relativePath = null;

		for (Iterator<?> iterator = files.iterator(); iterator.hasNext();) {
			File file = (File) iterator.next();
			if (file.getName().toLowerCase().contains(fileName.toLowerCase())) {
				relativePath = file.getPath();
				break;
			}
		}

		return relativePath;
	}

}
