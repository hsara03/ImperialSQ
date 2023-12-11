package test.java;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class MovieListingsSteps {

  private WebDriver driver;

  @Given("el usuario está en la página principal de cinesimperial")
  public void el_usuario_está_en_la_página_principal_de_cinesimperial() {
    driver = new ChromeDriver();
    driver.get("https://www.cinesimperial.com");
  }

  @When("el usuario hace clic en el botón 'En Cartell'")
  public void el_usuario_hace_clic_en_el_botón_En_Cartell() {
    WebElement buttonEnCartell = driver.findElement(By.cssSelector("button[data-filter='cat-cartell']"));
    buttonEnCartell.click();
  }

  @Then("se debe mostrar el listado de películas disponibles")
  public void se_debe_mostrar_el_listado_de_películas_disponibles() {
    WebElement movieList = driver.findElement(By.id("id_del_elemento_que_contiene_las_peliculas")); // Reemplazar con el ID correcto
    Assert.assertTrue("El listado de películas no se muestra.", movieList.isDisplayed());
  }

  // No olvides cerrar el navegador después de tus pruebas
  @io.cucumber.java.After
  public void cleanUp(){
    driver.quit();
  }
}
