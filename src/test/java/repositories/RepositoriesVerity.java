package repositories;

import org.openqa.selenium.support.FindBy;

public class RepositoriesVerity {

	
	@FindBy
	public String XPATH_BTN_CONTATO = "//a[contains(.,'Contato')][1]";
	
	@FindBy
	public String EMPRESA = "empresa";
	@FindBy
	public String nome = "nome";
	@FindBy
	public String email = "email";
	@FindBy
	public String telefone = "telefone";
	@FindBy
	public String XPATH_assunto = "//label/select";
	@FindBy
	public String mensagem = "mensagem";
	@FindBy
	public String BtnEnviar = "//div/button[@class='submit']";
	@FindBy
	public String MensagemSucesso = "//*[text()[contains(.,'Sua mensagem foi enviado com sucesso!')]]";
	
}
