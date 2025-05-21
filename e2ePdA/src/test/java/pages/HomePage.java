package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import drivers.Drivers;
import elementos.Elementos;
import executa.Executa;
import metodos.Metodos;

public class HomePage extends Drivers {

	Metodos metodo = new Metodos();
	Executa executa = new Executa();
	Elementos el = new Elementos();
	
	
	

	public void login(String email, String senha, String urlDesejada) {
		metodo.esperarElementoSerVisivel(el.getBtnEntrar(), 2);
		metodo.clicar(el.getBtnEntrar());
		metodo.escrever(el.getCampoEmail(), email);
		metodo.escrever(el.getCampoSenha(), senha);
		metodo.clicar(el.getBtnLogar());
		metodo.esperarUrlConter(urlDesejada, 2);
		
		

	}

	public void loginNegativo(String email, String senha, String msgDesejada) {
		metodo.esperarElementoSerVisivel(el.getBtnEntrar(), 2);
		metodo.clicar(el.getBtnEntrar());
		metodo.escrever(el.getCampoEmail(), email);
		metodo.escrever(el.getCampoSenha(), senha);
		metodo.clicar(el.getBtnLogar());
		if (msgDesejada.equals("Preencher campo obrigatório")) {
			metodo.esperarElementoSerVisivel(el.getMsgCampoObrigatorio(), 3);
			metodo.validarTexto(el.getMsgCampoObrigatorio(), msgDesejada);
		} else if (msgDesejada.equals("Email fora do padrão")) {
			metodo.esperarElementoSerVisivel(el.getMsgEmailInvalido(), 3);
			metodo.validarTexto(el.getMsgEmailInvalido(), msgDesejada);
		} else if (msgDesejada.equals("Usuário ou senha inválidos.")) {
			metodo.esperarElementoSerVisivel(el.getMsgUserPassInvalido(), 3);
			metodo.validarTexto(el.getMsgUserPassInvalido(), msgDesejada);
		}

	}
	
	public void logout(String email, String senha, String urlDesejada) {
		metodo.clicar(el.getBtnEntrar());
		metodo.escrever(el.getCampoEmail(), email);
		metodo.escrever(el.getCampoSenha(), senha);
		metodo.clicar(el.getBtnLogar());
		metodo.esperarElementoSerVisivel(el.getBtnLogout(), 3);
		metodo.clicar(el.getBtnLogout());
		metodo.esperarUrlSerVisivel(urlDesejada, 3);
		metodo.validarUrl(urlDesejada);
	}

}
