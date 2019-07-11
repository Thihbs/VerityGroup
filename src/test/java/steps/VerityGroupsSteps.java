package steps;

import org.junit.Assert;


import PagesVerity.PageContato;
import PagesVerity.PageInicial;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import utils.SeleniumUtils;

public class VerityGroupsSteps {
	PageInicial InicialPage = new PageInicial();
    PageContato PageCadastro = new PageContato();
	
	@Dado("que eu acessei a home page da Verity Group")
	public void que_eu_acessei_a_home_page_da_Verity_Group() {
	    Hooks.setUp();
	    
	}

	@Quando("eu clicar na opção de menu “Contato”")
	public void eu_clicar_na_opção_de_menu_Contato() {
		InicialPage.getBtnContato().click();
	}

	@Quando("preencher os campos (.*),(.*),(.*),(.*),Assunto e Mensagem")
	public void preencher_os_campos_Empresa_Nome_Email_Telefone_Assunto_e_Mensagem(String Empresa,String nome,String email,String telefone) {
		SeleniumUtils.centralize();
		PageCadastro.sendEmpresa().sendKeys(Empresa);
		PageCadastro.sendNome().sendKeys(nome);
		PageCadastro.sendEmail().sendKeys(email);
		PageCadastro.sendTelefone().sendKeys(telefone);
		PageCadastro.sendAssunto("Dúvidas");
		PageCadastro.SendMensagem().sendKeys("Gostaria muito de trabalhar com vocês");
		
	}

	@Quando("clicar no botão “Enviar”")
	public void clicar_no_botão_Enviar() {
		PageCadastro.ClickBtnEnviar().click();
	}

	@Então("o site irá registrar o envio apresentando uma mensagem de que a (.*) foi enviada com sucesso.")
	public void o_site_irá_registrar_o_envio_apresentando_uma_mensagem_de_que_a_mensagem_foi_enviada_com_sucesso(String mensagemEsperada) {
		String mensagem = PageCadastro.MensagemdeSucesso().getText();
		System.out.println(mensagem);
		Assert.assertEquals(mensagemEsperada,mensagem);
	}
	

}
