package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class MovieListingsSteps {

  @When("el usuario hace clic en el botón 'En Cartell'")
  public void el_usuario_hace_clic_en_el_botón_En_Cartell() {
    WebElement buttonEnCartell = CommonSteps.driver.findElement(By.cssSelector("button[data-filter-value='.cat-cartell']"));
    buttonEnCartell.click();
  }

  @Then("se debe mostrar el listado de películas disponibles")
  public void se_debe_mostrar_el_listado_de_películas_disponibles() {
    WebElement movieList = CommonSteps.driver.findElement(By.cssSelector("div[class='row grid pelis-grid']"));
    //assert
  }
}