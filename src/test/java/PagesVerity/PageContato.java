package PagesVerity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import factory.WebDriverFactory;
import repositories.RepositoriesVerity;
import utils.SeleniumUtils;

public class PageContato {
	RepositoriesVerity reposit = new RepositoriesVerity();
	
	
	public WebElement sendEmpresa() {
		SeleniumUtils.waitWebElementVisibleName(reposit.EMPRESA);
		return WebDriverFactory.getCurrentRunningDriver().findElement(By.name(reposit.EMPRESA));
	}
	public WebElement sendNome() {
		SeleniumUtils.waitWebElementVisibleName(reposit.nome);
		return WebDriverFactory.getCurrentRunningDriver().findElement(By.name(reposit.nome));
	}
	public WebElement sendEmail() {
		SeleniumUtils.waitWebElementVisibleName(reposit.email);
		return WebDriverFactory.getCurrentRunningDriver().findElement(By.name(reposit.email));
	}
	public WebElement sendTelefone() {
		SeleniumUtils.waitWebElementVisibleName(reposit.telefone);
		return WebDriverFactory.getCurrentRunningDriver().findElement(By.name(reposit.telefone));
	}
	
	public static void sendAssunto(String assunto) {
		SeleniumUtils.waitWebElementVisible("//label/select");
	Select Assunto = new Select(WebDriverFactory.getCurrentRunningDriver().findElement(By.xpath("//label/select")));
	Assunto.selectByVisibleText(assunto);

		}
	public WebElement  SendMensagem() {
		SeleniumUtils.waitWebElementVisibleName(reposit.mensagem);
		return WebDriverFactory.getCurrentRunningDriver().findElement(By.name(reposit.mensagem));
	}
	public WebElement  ClickBtnEnviar() {
		SeleniumUtils.waitWebElementVisible(reposit.BtnEnviar);
		return WebDriverFactory.getCurrentRunningDriver().findElement(By.xpath(reposit.BtnEnviar));
	}
	
	public WebElement MensagemdeSucesso() {
		SeleniumUtils.waitWebElementVisible(reposit.MensagemSucesso);
		return WebDriverFactory.getCurrentRunningDriver().findElement(By.xpath(reposit.MensagemSucesso));
	}
	}


