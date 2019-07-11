package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighLight {

	public boolean highlightElement(WebDriver driver, WebElement element) {
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

	public boolean UnhighlightElement(WebDriver driver, WebElement element) {
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
}
