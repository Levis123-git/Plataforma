package elementos;

import org.openqa.selenium.By;

import lombok.Getter;

@Getter
public class Elementos {

	/**
	 * Elementos e mensagens de erro da loginPage
	 */
	private By btnEntrar = By.xpath("//button[text()='ENTRAR']");
	private By campoEmail = By.xpath("//*[@placeholder='Digite seu e-mail']");
	private By campoSenha = By.xpath("//*[@placeholder='Senha']");
	private By btnLogar = By.xpath("//*[@class='btn-login']");
	private By msgCampoObrigatorio = By.xpath("//input[@placeholder='Digite seu e-mail']/following-sibling::span[@class='erro']");
	private By msgUserPassInvalido = By.xpath("//p[text()='Usuário ou senha inválidos.']");
	private By msgEmailInvalido = By.xpath("//span[text()='Email fora do padrão']");
	private By btnLogout = By.id("btn-sair");
	private By encerrarSessao = By.xpath("//button[@class='btn-sim']");
}

