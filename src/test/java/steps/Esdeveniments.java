package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Esdeveniments {

    boolean existenEventos = false;

    @Given("el usuario esta en la pagina principal de eventos")
    public void elUsuarioEstaEnLaPaginaPrincipalDeEventos() {
        Driver.getDriver().get("https://www.cinesimperial.com/index.php?option=com_cines&task=esdeveniments&Itemid=158");
    }

    @Then("si hay un evento disponible, se comprueban los detalles")
    public void siHayUnEventoDisponibleSeCompruebanLosDetalles() {
        List<WebElement> eventos = Driver.getDriver().findElements(By.className("peli-item"));
        if(eventos.isEmpty()) return; // nada que probar
        eventos.getLast().click();
        eventos.getLast().findElement(By.className("peli-boto-info")).click();
        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(), "https://www.cinesimperial.com/index.php?option=com_cines&task=esdeveniments&Itemid=158");
        existenEventos = true;
    }

    @Then("si hay un evento disponible, es escoge una hora")
    public void siHayUnEventoDisponibleEsEscogeUnaHora() {
        if(!existenEventos) return; // nada que probar
        List<WebElement> horas = Driver.getDriver().findElements(By.className("horasessio"));
        if(horas.isEmpty()) return; // no hay horas que seleccionar
        horas.getLast().click();
    }
}
