package util.selenium;

import java.text.SimpleDateFormat;
import java.time.Instant;

public class DateTimeUtils {

	public static String getHoraAtual() {
		Instant instante = Instant.now();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(instante.toEpochMilli());
	}

	public static String getDiaAtual() {
		Instant instante = Instant.now();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(instante.toEpochMilli());
	}

	public static String getDtHr() {
		String dia = getDiaAtual().replaceAll("/", "-");
		String hora = getHoraAtual().replaceAll(":", "_");
		return dia + "__" + hora;
	}

}
