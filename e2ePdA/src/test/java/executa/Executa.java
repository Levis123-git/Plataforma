package executa;

import drivers.Drivers;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Executa extends Drivers {

    public void setup(){
        try {
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.get("https://plataforma.dev.e2etreinamentos.com.br/");
            driver.manage().window().maximize();
        } catch (Exception e) {
            throw new WebDriverException("Não foi possivel abrir o navegador.");
        }

    }

    public void tearDown(){
    	
        if (driver!= null){
            driver.quit();
        }

    }
}
