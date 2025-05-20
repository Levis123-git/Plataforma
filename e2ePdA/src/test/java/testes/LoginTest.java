package testes;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import drivers.Drivers;
import executa.Executa;
import pages.HomePage;


public class LoginTest extends Drivers {

	HomePage home = new HomePage();
	Executa executa = new Executa();
		
	@BeforeMethod
	void antesDosTestes() {
		executa.setup();
	}
	@AfterMethod
	void depoisDosTestes() {
		executa.tearDown();
	}
	
	@Test(priority = 1)
	void logoutSucesso() {
		home.logout("johnson139@e2etreinamentos.com.br", "Teste@1234", "https://plataforma.dev.e2etreinamentos.com.br/");
	}
	
	
	@Test(priority = 2)
	void loginSucesso() {
		home.login("johnson139@e2etreinamentos.com.br", "Teste@1234", "/dashboard");
	}
	
	@Test(priority = 3)
	void naoDeveLogarEmailIncorreto() {
		home.loginNegativo("johnson139e2etreinamentos.com.br", "Teste@1234", "Email fora do padrão");
	}
	
	@Test(priority = 4)
	void naoDeveLogarSenhaIncorreta() {
		home.loginNegativo("johnson139@e2etreinamentos.com.br", "Tes", "Usuário ou senha inválidos.");
	}
	
	@Test(priority = 5)
	void naoDeveLogarCamposEmBranco() {
		home.loginNegativo("", "", "Preencher campo obrigatório");
	}
	
	
	
}
