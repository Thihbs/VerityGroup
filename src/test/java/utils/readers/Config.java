package utils.readers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import utils.exceptions.ExceptionUtils;

public class Config {
		
	/**
	 * Este método lê um arquivo de properties e retorna o valor correspondente pela chave informada
	 * @author Fábio Vaz
	 * @since 27/09/2018
	 */
	public static String getProperty(String value) {
		
		Properties properties = null;
		InputStream inputStream = null;
		
		try {
			inputStream = new FileInputStream("./src/main/resources/properties/config.properties");
			properties = new Properties();
			properties.load(inputStream); 
		} catch (Exception exception) {
			ExceptionUtils.throwException(exception);
		} 
				
		return properties.getProperty(value).trim();
	}
	
}
