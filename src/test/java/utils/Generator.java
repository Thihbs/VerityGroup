package utils;

import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import utils.exceptions.*;

public class Generator {
	static Document document = new Document();
	static int cont = 0;
	static int cont1 = 0;
	static int cont2 = 0;

	public static void gerar(String Cenario) {
		// Criação do documento

		try {
			/*
			 * PdfWriter.getInstance(document, new FileOutputStream("./target/"+
			 * Cenario + ".pdf"));
			 */
			document.close();
			PdfWriter.getInstance(document, new FileOutputStream("./target/" + Cenario + ".pdf"));
			document.open();
			document.newPage();
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

	}

	public static void addExternalImage(String path, int align, float ySize, float xSize) {
		try {
			Image image = Image.getInstance(path);
			image.setAlignment(align);
			image.scaleAbsolute(ySize, xSize);
			document.add(image);
		} catch (Exception exception) {
			ExceptionUtils.throwException(exception);
		}

	}

	public static void insertPrint(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] imagem = ts.getScreenshotAs(OutputType.BYTES);
		cont++;
		if (cont == 3) {
			cont = 1;
			document.newPage();

		}
		try {
			Image image = Image.getInstance(imagem);
			image.scaleToFit(520f, 520f);
			document.add(image);

		} catch (Exception exception) {
			ExceptionUtils.throwException(exception);

		}

	}

	public static void print(String text, WebDriver driver) {

		addNewPage();
		insertPrint(driver);
		addText(text);

	}

	public static void addText(String text) {
		try {
			document.add(new Paragraph(text));
		} catch (Exception exception) {
			ExceptionUtils.throwException(exception);
		}

	}

	public static void addFormatedText(String text, String name, float size, int style, BaseColor color,
			int spaceBefore, int spaceAfter, int align) {
		try {

			Font font = FontFactory.getFont(name, size, style, color);
			Paragraph paragraph = new Paragraph(text, font);
			paragraph.setSpacingBefore(spaceBefore);
			paragraph.setSpacingAfter(spaceAfter);
			paragraph.setAlignment(align);
			document.add(paragraph);

		} catch (Exception exception) {
			ExceptionUtils.throwException(exception);
		}
	}

	public static void addFormatedText(String text, String name, int style, BaseColor color) {

		addFormatedText(text, name, 12, style, color, 0, 0, 0);
	}

	public static void addNewPage() {
		document.newPage();

	}

	public static void FinishPDF() {
		document.close();
	}

	public static void CRMCOVER(String Cenario) {
		gerar(Cenario);
		addExternalImage("src/main/resources/images/bbdental.png/", Element.ALIGN_JUSTIFIED, 300f, 150f);
		Generator.addFormatedText("BBDENTAL :\n" + "Portal \n" + "Cenario: " + Cenario.toLowerCase(),
				FontFactory.HELVETICA, 20, Font.BOLDITALIC, BaseColor.BLUE, 40, 200, Element.ALIGN_CENTER);
		Generator.TextData();
		document.newPage();
	}

	public static void TextData() {
		Generator.addText("Data atual: " + DateTimeUtils.insertDateNow());
		Generator.addText("Hora atual: " + DateTimeUtils.insertTimeNow() + " - hora do Brasil");
		Generator.addText("Enderecoo IP: " + InfraUtils.getIpClient());
		Generator.addText("Usuario local ou de rede: " + InfraUtils.getWindowsUser());
		Generator.addText("Nome do computador de execucao: " + InfraUtils.getPcName());
	}
}