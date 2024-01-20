package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    @After
    public void closeBrowser() {
        if(driver==null) return;
        driver.close();
        driver = null;
    }

    @Given("el usuario esta en la pagina principal de cinesimperial")
    public void elUsuarioEstaEnLaPaginaPrincipalDeCinesimperial() {
        Driver.getDriver().get("https://www.cinesimperial.com");
    }
}

