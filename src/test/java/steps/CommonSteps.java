package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonSteps {

  private static WebDriver driver;

  public static WebDriver getDriver(){
    if (driver == null) {
      driver = new ChromeDriver();
    }
    return driver;
  }


  @Given("el usuario está en la página principal de cinesimperial")
  public void el_usuario_está_en_la_página_principal_de_cinesimperial() {
    getDriver().get("https://www.cinesimperial.com");
  }

}
