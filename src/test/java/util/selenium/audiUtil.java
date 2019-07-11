package util.selenium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.WebDriverFactory;

public class audiUtil {
	public static WebDriver driver;
	WebElement webElement;
	private WebDriverWait wait;
	public Integer timeToBrooke;

	public audiUtil() {
		timeToBrooke = Integer.parseInt(getProperty("time.to.brooke"));
		driver = WebDriverFactory.getCurrentRunningDriver();
	}

	public static void takeScreenshot(String fileName) {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date data = new Date();
		try {
			FileUtils.copyFile(scrFile, new File(".//target//evidencias" + fileName + data + ".png"), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Mata_Processos
	public static void KillProcess() {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String lerArquivo(String path) {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(path));
			while (reader.ready()) {
				sb.append(reader.readLine());
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public boolean highlightElement(WebElement element) {
		try {
			if (driver instanceof JavascriptExecutor) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].style.border='3px solid red'", element);
				driver = null;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	/**
	 * Retorna_IP_Maquina_Execucao
	 */
	public String getIpClient() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (Exception exception) {
			throwException(exception);
		}
		return null;
	}

	/**
	 * Retorna_Nome_Maquina
	 */
	public String getPcName() {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			return addr.getHostName();
		} catch (Exception exception) {
			throwException(exception);
		}
		return null;
	}

	public void throwException(Exception exception) {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(exception.getMessage() + "\n");
		for (StackTraceElement trace : exception.getStackTrace()) {
			stringBuilder.append(trace.toString() + "\n");
		}

	}

	/**
	 * Usuario_Logado_Maquina_Execução
	 */
	public String getWindowsUser() {
		return System.getProperty("user.name");
	}

	/**
	 * Copia_para_Origem_Destino
	 */
	public void copyFile(String pathWithExtensionFileOrigem, String pathWithExtensionFileDetino) {
		try {
			FileUtils.copyFile(new File(pathWithExtensionFileOrigem), new File(pathWithExtensionFileDetino));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Start_(.Bat)
	 */
	public void acionarBat(String path, String nomeBat) {
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
	 * Verifica_Existencia_Arquivo_Passando_Caminho_Nome_Extensao
	 */
	public boolean isFile(String path) {
		return new File(path).exists();
	}

	public boolean UnhighlightElement(WebElement element) {
		try {
			if (driver instanceof JavascriptExecutor) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].style.border=''", element, "");
				driver = null;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	public String formataData(String data) {
		return formataData(data, "");
	}

	public String formataData(String data, String pattern) {

		if (data.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {

			String ano = data.substring(0, 4);
			String mes = data.substring(5, 7);
			String dia = data.substring(8, 10);

			return dia + "/" + mes + "/" + ano;
		}

		return data;
	}

	/**
	 * Retorna_Data_Atual
	 */
	public String insertDateNow() {
		try {
			SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
			return formatDate.format(new Date());
		} catch (Exception exception) {
			throwException(exception);
		}
		return null;
	}

	/**
	 * Retorna_Hora_Atual
	 */
	public String insertTimeNow() {
		SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm:ss a");
		return formatTime.format(new Date());
	}

	public WebElement getWebElement(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public void Enter(String xpath) {
		driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
	}

	public void DOWN(String xpath) {
		driver.findElement(By.xpath(xpath)).sendKeys(Keys.DOWN);
	}

	public void DigitePorCaracter(String xpath, String value) {
		String val = value;
		WebElement element = driver.findElement(By.xpath(xpath));
		element.clear();

		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			element.sendKeys(s);
		}
	}

	public List<WebElement> getWebElements(String xpath) {
		return driver.findElements(By.xpath(xpath));
	}

	public Select getSelect(String xpath) {
		return new Select(getWebElement(xpath));
	}

	public void waitWebElementVisible(String xpath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeToBrooke);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception exception) {
			throwException(exception);
		}
	}

	public void waitWebElementClickable(String xpath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeToBrooke);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		} catch (Exception exception) {
			throwException(exception);
		}
	}

	public void clickJavascript(String xpath) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(xpath));
		executor.executeScript("arguments[0].click();", element);
	}

	public void clickJavascriptVariante(String xpath) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(xpath));
		executor.executeScript("arguments[1].click();", element);
	}

	public void scroolPositivo() {
		JavascriptExecutor jsP;
		jsP = (JavascriptExecutor) driver;
		jsP.executeScript("scrollBy(0, 450)", "");
	}

	public void scroolNegativo() {
		JavascriptExecutor jsN;
		jsN = (JavascriptExecutor) driver;
		jsN.executeScript("scrollBy(0, -300)", "");
	}

	public void cliks(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void waitWebElementSelectable(String xpath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeToBrooke);
			wait.until(ExpectedConditions.elementToBeSelected(By.xpath(xpath)));
		} catch (Exception exception) {
			throwException(exception);
		}
	}

	public void waitAlertPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeToBrooke);
			wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception exception) {
			throwException(exception);
		}
	}

	public void sendText(String texto, String xpath) {
		waitWebElementVisible(xpath);
		getWebElement(xpath).clear();
		getWebElement(xpath).sendKeys(texto);
	}

	public void click(String xpath) {
		waitWebElementClickable(xpath);
		getWebElement(xpath).click();
	}

	public void selectCombo(String value, String xpath) {
		waitWebElementSelectable(xpath);
		getSelect(xpath).selectByValue(value);
	}

	public void switchJanela() {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
	}

	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}

	public WebDriver switchToFrame(String xpath) {
		return driver.switchTo().frame(getWebElement(xpath));
	}

	public void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception exception) {
			throwException(exception);
		}
	}

	public String getTextoAlert() {
		wait(2000);
		waitAlertPresent();
		return driver.switchTo().alert().getText();
	}

	public void alertAccept() {
		waitAlertPresent();
		driver.switchTo().alert().accept();
	}

	public void alertCancel() {
		waitAlertPresent();
		driver.switchTo().alert().dismiss();
	}

	public boolean isAlert() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getUrl(String xpath) {
		return driver.getCurrentUrl();
	}

	public void get(String url) {
		System.out.println(driver != null ? "DRIVER NAO NULO" : "DRIVER NULO!");
		driver.get(url);
	}

	public String getText(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void Close() {
		driver.quit();
	}

	public void centralize(WebElement... elements) {
		for (WebElement element : elements) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded(true);", element);
			break;
		}
	}

	/**
	 * Le_Arquivo_Properties_e_Retorna_valor_correspondente_pela_chave_informada
	 */
	public String getProperty(String value) {

		Properties properties = null;
		InputStream inputStream = null;

		try {
			inputStream = new FileInputStream("./src/main/resources/properties/config.properties");
			properties = new Properties();
			properties.load(inputStream);
		} catch (Exception exception) {
			throwException(exception);
		}

		return properties.getProperty(value).trim();
	}

	public String waitExistGetText(String elemento, int timeOut) throws InterruptedException {
		for (int i = 1; i <= timeOut; i++) {
			try {
				WebElement element = driver.findElement(By.xpath(elemento));
				if (element.isDisplayed()) {
					String texto = element.getText();
					return texto;
				}
			} catch (Exception e) {
				if (i == (timeOut / 2)) {
					driver.navigate().refresh();
					Thread.sleep(2000);
				} else if (i == (timeOut - 1)) {
					JOptionPane.showMessageDialog(null,
							"Elemento " + elemento + " não foi apresentado na tela em " + timeOut + " segundos.");
					driver.quit();
				}
				Thread.sleep(2000);
			}
		}
		return elemento;
	}

	public WebElement waitWebElementVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitURL(String url) {
		wait.until(ExpectedConditions.urlContains(url));
	}

	public void waitFrameAndSwitch(WebElement frame) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
	}

	public void waitTextInElement(WebElement elemento, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(elemento, text));
	}

	public WebElement waitWebElementClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public Alert getAlert() {
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}

	public boolean elementExists(WebElement element) {
		try {
			moveToElement(element);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public WebElement selectItemComboBox(String nomeItem) {
		return driver.findElement(By.linkText(nomeItem));
	}

	public void moveToElement(WebElement elemento) {
		Actions acao = new Actions(driver);
		acao.moveToElement(elemento).build().perform();
	}
}
