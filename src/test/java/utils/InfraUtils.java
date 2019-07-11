package utils;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import org.apache.commons.io.FileUtils;

import utils.exceptions.ExceptionUtils;

public class InfraUtils {

	/**
	 * Este método retorna o ip da máquina de execução do teste
	 * 
	 * @author Fábio Vaz
	 * @return
	 * @since 27/09/2018
	 */
	public static String getIpClient() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (Exception exception) {
			ExceptionUtils.throwException(exception);
		}
		return null;
	}

	/**
	 * Este método retorna o nome do computador
	 * 
	 * @author Fábio Vaz
	 * @return
	 * @since 27/09/2018
	 */
	public static String getPcName() {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			return addr.getHostName();
		} catch (Exception exception) {
			ExceptionUtils.throwException(exception);
		}
		return null;
	}

	/**
	 * Este método o usuário logado na máquina de execução do teste
	 * 
	 * @author Fábio Vaz
	 * @since 27/09/2018
	 */
	public static String getWindowsUser() {
		return System.getProperty("user.name");
	}

	/**
	 * Este mátodo copia um arquivo de origem para destino
	 * 
	 * @author Fábio Vaz
	 * @since 26/11/2018
	 * @param origem
	 * @param destino
	 */
	public static void copyFile(String pathWithExtensionFileOrigem, String pathWithExtensionFileDetino) {
		try {
			FileUtils.copyFile(new File(pathWithExtensionFileOrigem), new File(pathWithExtensionFileDetino));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Este método aciona um arquivo .bat
	 * 
	 * @author Fábio Vaz
	 * @since 26/11/2018
	 */
	public static void acionarBat(String path, String nomeBat) {
		ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", "Start", nomeBat);
		File dir = new File(path);
		pb.directory(dir);
		Process p = null;
		try {
			p = pb.start();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.destroy();
	}

	/**
	 * Este método verifica se existe um arquivo passando o caminho com nome do
	 * arquivo e extensão
	 * 
	 * @author Fábio Vaz
	 * @since 27/11/2018
	 */
	public static boolean isFile(String path) {
		return new File(path).exists();
	}

}
