package metodos;

import drivers.Drivers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

import java.time.Duration;


public class Metodos extends Drivers {

	public void escrever(By locator, String texto) {
		try {
			driver.findElement(locator).sendKeys(texto);
		} catch (Exception e) {
			throw new NoSuchElementException("Elemento não encontrado: " + locator);
		}
	}

	public void clicar(By locator) {
		try {
			driver.findElement(locator).click();
		} catch (Exception e) {
			throw new NoSuchElementException("Elemento não encontrado: " + locator);
		}
	}

	public void validarUrl(String urlEsperada) {
		try {
			String urlCapturada = driver.getCurrentUrl();
			assertEquals(urlCapturada, urlEsperada);
		} catch (Exception e) {
			throw new NotFoundException("URL não encontrada");
		}
	}

	public void validarTexto(By locator, String textoEsperado) {
		try {
			String textoCapturado = driver.findElement(locator).getText();
			assertEquals(textoCapturado, textoEsperado);
		} catch (Exception e) {
			throw new NotFoundException("Elemento não encontrado: " + locator);
		}
	}

	public void esperarElementoSerVisivel(By locator, int tempoDeEspera) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tempoDeEspera));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void esperarUrlConter(String parteDaUrl, int tempoDeEspera) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tempoDeEspera));
	    wait.until(ExpectedConditions.urlContains(parteDaUrl));
	}
	public void esperarUrlSerVisivel(String urlEsperada, int tempoDeEspera) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tempoDeEspera));
	    wait.until(ExpectedConditions.urlToBe(urlEsperada));
	}



}
