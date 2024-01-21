package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class MovieListings {

    @When("el usuario hace clic en el botón {string}")
    public void elUsuarioHaceClicEnElBotónEnCartell(String arg0) {
        WebElement buttonEnCartell = Driver.getDriver().findElement(By.cssSelector("button[data-filter-value='.cat-cartell']"));
        buttonEnCartell.click();
    }

    @Then("se debe mostrar el listado de películas disponibles")
    public void seDebeMostrarElListadoDePelículasDisponibles() {
        WebElement moveListWrapper = Driver.getDriver().findElement(By.cssSelector("div[class='row grid pelis-grid']"));
        Assert.assertNotNull(moveListWrapper);
        List<WebElement> movies = Driver.getDriver().findElements(By.cssSelector(".peli-item"));
        Assert.assertFalse(movies.isEmpty());
    }

    @When("el usuario hace clic en el dropdown todos los generos")
    public void elUsuarioHaceClicEnElDropdownTodosLosGeneros() {
        WebElement list = Driver.getDriver().findElement(By.id("soflow-color"));
        list.click();
    }

    @Then("se deben mostrar los generos")
    public void seDebenMostrarLosGeneros() {
        List<WebElement> list = Driver.getDriver().findElements(By.cssSelector("#soflow-color option"));
        Assert.assertFalse(list.isEmpty());
    }

    @And("se deben filtrar las peliculas que coincidan con ese genero")
    public void seDebenFiltrarLasPeliculasQueCoincidanConEseGenero() throws InterruptedException {
        Select selectorElement = new Select(Driver.getDriver().findElement(By.id("soflow-color")));
        selectorElement.selectByIndex(1);
        Thread.sleep(1000);
        List<WebElement> moviesAfterListing = Driver.getDriver().findElements(By.cssSelector(".peli-item"));
        boolean hidden = false;
        for (WebElement movie:moviesAfterListing){
            System.out.println(movie.getCssValue("display"));
            if(movie.getCssValue("display").equalsIgnoreCase("none")){
                hidden = true;
                break;
            }
        }
        Assert.assertTrue(hidden);
    }

    @When("el usuario hace clic en el modo poster")
    public void elUsuarioHaceClicEnElModoPoster() throws InterruptedException {
        Driver.getDriver().findElement(By.cssSelector(".boto_f_poster")).click();
    }

    @Then("las peliculas se muestran en modo poster")
    public void lasPeliculasSeMuestranEnModoPoster() {
        Assert.assertTrue(Driver.getDriver().findElements(By.cssSelector(".pelis-grid.format_llista")).isEmpty());
        Assert.assertFalse(Driver.getDriver().findElements(By.cssSelector(".pelis-grid")).isEmpty());
    }

    @When("el usuario hace clic en el modo lista")
    public void elUsuarioHaceClicEnElModoLista() throws InterruptedException {
        Driver.getDriver().findElement(By.cssSelector(".boto_f_llista")).click();
    }

    @Then("las peliculas se muestran en modo lista")
    public void lasPeliculasSeMuestranEnModoLista() {
        Assert.assertFalse(Driver.getDriver().findElements(By.cssSelector(".pelis-grid.format_llista")).isEmpty());
    }
}
