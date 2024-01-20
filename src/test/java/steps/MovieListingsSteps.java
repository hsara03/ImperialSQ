package steps;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.List;


public class MovieListingsSteps {

  @When("el usuario hace clic en el botón 'En Cartell'")
  public void el_usuario_hace_clic_en_el_botón_En_Cartell() {
    WebElement buttonEnCartell = CommonSteps.getDriver().findElement(By.cssSelector("button[data-filter-value='.cat-cartell']"));
    buttonEnCartell.click();
  }

  @Then("se debe mostrar el listado de películas disponibles")
  public void se_debe_mostrar_el_listado_de_películas_disponibles() {
    WebElement moveListWrapper = CommonSteps.getDriver().findElement(By.cssSelector("div[class='row grid pelis-grid']"));
    Assert.assertNotNull(moveListWrapper);
    List<WebElement> movies = CommonSteps.getDriver().findElements(By.cssSelector(".peli-item"));
    Assert.assertFalse(movies.isEmpty());
  }

  @When("el usuario hace clic en el dropdown todos los generos")
  public void el_usuario_hace_clic_en_el_dropdown_todos_los_generos() {
    WebElement list = CommonSteps.getDriver().findElement(By.id("soflow-color"));
    list.click();
  }
  @Then("se deben mostrar los generos")
  public void se_deben_mostrar_los_generos() {
    List<WebElement> list = CommonSteps.getDriver().findElements(By.cssSelector("#soflow-color option"));
    Assert.assertFalse(list.isEmpty());
  }
  @Then("se deben filtrar las peliculas que coincidan con ese genero")
  public void se_deben_filtrar_las_peliculas_que_coincidan_con_ese_genero() {
    List<WebElement> moviesBeforeFiltering = CommonSteps.getDriver().findElements(By.cssSelector(".peli-item"));
    Select selectorElement = new Select(CommonSteps.getDriver().findElement(By.id("soflow-color")));
    selectorElement.selectByIndex(1);
    List<WebElement> moviesAfterListing = CommonSteps.getDriver().findElements(By.cssSelector(".peli-item"));
    Assert.assertNotEquals(moviesBeforeFiltering, moviesAfterListing);
  }
}