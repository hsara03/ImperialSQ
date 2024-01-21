package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Random;

public class Driver {
    private static WebDriver driver;

    public static final String CHROME = "chrome";
    public static final String EDGE = "edge";
    public static String driverType = CHROME;

    public static void setDefaultDriver(String driver) {
        Driver.driverType = driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (driverType) {
                case CHROME -> driver = new ChromeDriver();
                case EDGE -> driver = new EdgeDriver();
                default -> throw new RuntimeException("unknown driver");
            }
        }
        driver.manage().window().setSize(new Dimension(1201, 1000));
        return driver;
    }

    @After
    public void closeBrowser() {
        if(driver==null) return;
        try {
            driver.close();
        } catch (UnhandledAlertException exception){
            driver.switchTo().alert().accept();
            driver.close();
        }
        driver = null;
    }

    @Given("el usuario esta en la pagina principal de cinesimperial")
    public void elUsuarioEstaEnLaPaginaPrincipalDeCinesimperial() {
        Driver.getDriver().get("https://www.cinesimperial.com");
    }
}

