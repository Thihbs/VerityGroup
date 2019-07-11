package PagesVerity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import factory.WebDriverFactory;
import repositories.RepositoriesVerity;
import utils.SeleniumUtils;

public class PageInicial {
	RepositoriesVerity reposit = new RepositoriesVerity();
	
	public static void setUrl() {
		
	}
	public  WebElement getBtnContato() {
		SeleniumUtils.waitWebElementVisible(reposit.XPATH_BTN_CONTATO);
		return WebDriverFactory.getCurrentRunningDriver().findElement(By.xpath(reposit.XPATH_BTN_CONTATO));
	}
	
	
		
		
	}
	
	


