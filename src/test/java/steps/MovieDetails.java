package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class MovieDetails {

    @And("el usuario accede a una pelicula")
    public void elUsuarioAccedeAUnaPelicula() throws InterruptedException {
        WebElement primeraPelicula = Driver.getDriver().findElement(By.cssSelector("div.peli-item:first-of-type"));
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(primeraPelicula).perform();
        Thread.sleep(1000);
        primeraPelicula.findElement(By.cssSelector("a")).click();
    }

    @When("el usuario hace clic en el boton Trailer")
    public void elUsuarioHaceClicEnElBotonTrailer() {
        Driver.getDriver().findElement(By.className("peli-boto-trailer")).click();
    }

    @When("el usuario hace click en una de las horas")
    public void elUsuarioHaceClickEnUnaDeLasHoras() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> botonesHora = Driver.getDriver().findElements(By.cssSelector("button.btn"));
        WebElement ultimaHoraDisponible = botonesHora.get(botonesHora.size() - 1);
        ultimaHoraDisponible.click();
    }

    @Then("el usuario debe empezar el proceso de checkout")
    public void elUsuarioDebeEmpezarElProcesoDeCheckout() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.cinesimperial.com/compra/show_confirmation.php");
    }
}
