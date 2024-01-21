package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.interactions.Actions;





public class Homepage {

    @When("el usuario hace clic en el icono de {string}")
    public void elUsuarioHaceClicEnElIconoDe(String socialMedia) {
        Driver.getDriver().get("https://www.cinesimperial.com/index.php");
        switch (socialMedia) {
            case "Facebook": {
                Driver.getDriver().findElement(By.className("rt-facebook-btn")).click();
                break;
            }
            case "Twitter": {
                Driver.getDriver().findElement(By.className("rt-twitter-btn")).click();
                break;
            }
            case "Instagram": {
                Driver.getDriver().findElement(By.className("rt-google-btn")).click();
                break;
            }
            default:
                throw new IllegalArgumentException("Social media not recognized: " + socialMedia);
        }
    }

    @When("el usuario selecciona la opción {string}")
    public void elUsuarioSeleccionaLaOpción(String viewOption) {
        String cssSelector = "";
        if ("Vista Póster".equals(viewOption)) {
            cssSelector = "button.boto_format.boto_f_poster";
        } else if ("Vista Lista".equals(viewOption)) {
            cssSelector = "button.boto_format.boto_f_llista";
        } else {
            throw new IllegalArgumentException("View option not recognized: " + viewOption);
        }
        Driver.getDriver().findElement(By.cssSelector(cssSelector)).click();

    }

    @Then("se inicia el proceso de compra de entradas para la película")
    public void seIniciaElProcesoDeCompraDeEntradasParaLaPelicula() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> hours = Driver.getDriver().findElements(By.cssSelector(".horasessio button"));
        Assert.assertFalse(hours.isEmpty());
        hours.getFirst().click();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.cinesimperial.com/compra/show_confirmation.php");
    }

    @Then("se reproduce el tráiler de la película")
    public void seReproduceElTrailerDeLaPelicula() throws InterruptedException {
        WebElement trailerModal = Driver.getDriver().findElement(By.cssSelector(".lity-wrap"));
        Assert.assertTrue(trailerModal.isDisplayed(), "El tráiler no se está reproduciendo.");
        Thread.sleep(1000);
    }

    @Then("se vuelve a la página principal")
    public void seVuelveaLaPaginaPrincipal() {
        Driver.getDriver().get("https://www.cinesimperial.com/index.php");
    }

    @Then("el usuario debería ser dirigido a la página de Facebook de Cines Imperial")
    public void elUsuarioDeberíaSerDirigidoALaPáginaDeFacebookDeCinesImperial() {
            String expectedUrl = "https://es-es.facebook.com/CinesImperial";
            String actualUrl = Driver.getDriver().getCurrentUrl();
            Assert.assertTrue(actualUrl.contains(expectedUrl), "URL does not match expected Facebook page URL.");
    }
    @Then("el usuario debería ser dirigido a la página de Twitter de Cines Imperial")
    public void elUsuarioDeberíaSerDirigidoALaPáginaDeTwitterDeCinesImperial() {
        String expectedUrl = "https://twitter.com/cinesimperial";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl), "URL does not match expected Twitter page URL.");
    }

    @Then("el usuario debería ser dirigido a la página de Instagram de Cines Imperial")
    public void elUsuarioDeberíaSerDirigidoALaPáginaDeInstagramDeCinesImperial() {
        String expectedUrl = "https://www.instagram.com/cinesimperial/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl), "URL does not match expected Intagram page URL.");
    }

    @When("el usuario hace clic en la flecha {string} del carrusel")
    public void elUsuarioHaceClicEnLaFlechaDelCarrusel(String direction) {
        String arrowSelector = direction.equals("derecha") ? ".owl-next" : ".owl-prev";
        WebElement arrowButton = Driver.getDriver().findElement(By.cssSelector(arrowSelector));
        arrowButton.click();

    }

    @Then("el carrusel debería desplazarse a la siguiente imagen")
    public void elCarruselDeberíaDesplazarseALaSiguienteImagen() {
        //TODO YO QUE SE TETE TIO NOSE COMO HACER ESTA MIERDA



    }

    @Then("el carrusel debería desplazarse a la imagen anterior")
    public void elCarruselDeberíaDesplazarseALaImagenAnterior() {
        //TODO YO QUE SE TETE TIO NOSE COMO HACER ESTA MIERDA


    }

    @Then("se deberían mostrar las películas en formato de póster")
    public void seDeberíanMostrarLasPelículasEnFormatoDePóster() {
        List<WebElement> gridElements = Driver.getDriver().findElements(By.cssSelector(".pelis-grid:not(.format_llista)"));
        Assert.assertFalse( gridElements.isEmpty(), "The movies are not displayed in poster format");
    }

    @Then("se deberían mostrar las películas en formato de lista")
    public void seDeberíanMostrarLasPelículasEnFormatoDeLista() {
        List<WebElement> gridElements = Driver.getDriver().findElements(By.cssSelector(".pelis-grid.format_llista"));
        Assert.assertFalse(gridElements.isEmpty(),"The movies are not displayed in list format");
    }


    @When("el usuario pasa por encima con el cursor en la película {string}")
    public void elUsuarioPasaPorEncimaConElCursorEnLaPelicula(String nombrePelicula) {
        WebElement pelicula = Driver.getDriver().findElement(By.xpath("//h4[text()='" + nombrePelicula + "']"));
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(pelicula).perform();
    }

    @Then("se muestran los horarios disponibles para el día actual")
    public void seMuestranLosHorariosDisponiblesParaElDiaActual() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> horarios = Driver.getDriver().findElements(By.cssSelector(".horasessio button:not([aria-disabled='true'])"));
        Assert.assertTrue(!horarios.isEmpty(), "No se encontraron horarios disponibles para hoy.");
    }

    @When("el usuario visualiza diferentes horas que hay de la película")
    public void elUsuarioVisualizaDiferentesHorasQueHayDeLaPelicula() {
        List<WebElement> horas = Driver.getDriver().findElements(By.cssSelector(".horasessio button"));
        Assert.assertTrue(!horas.isEmpty(), "No se encontraron horas para la película.");
    }

    @When("el usuario hace clic en VEURE MÉS DIES")
    public void elUsuarioHaceClicEnVeureMesDies() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.cssSelector(".veuremes a[href*='film-4688/p?beekeeper-el-protector']")).click();
    }

    @When("el usuario hace clic en TRAILER")
    public void elUsuarioHaceClicEnVeureTrailer() {
        Driver.getDriver().findElement(By.className("peli-boto-trailer")).click();
    }

    @When("el usuario cierra el trailer")
    public void elUsuarioCierraElTrailer() throws InterruptedException {
        Driver.getDriver().findElement(By.className("lity-close")).click();
    }

    @When("el usuario hace clic en COMPRAR")
    public void elUsuarioHaceClicEnComprar() throws InterruptedException {
        Driver.getDriver().findElement(By.className("peli-boto-info")).click();
    }

    @Then("se muestran todos los días disponibles con sus respectivos horarios")
    public void seMuestranTodosLosDiasDisponiblesConSusRespectivosHorarios() {
        String expectedUrl = "https://www.cinesimperial.com//film-4688/p?beekeeper-el-protector";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl), "URL does not match expected  page URL.");
    }
}
