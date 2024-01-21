package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MapView {
    @Given("el usuario se encuentra en On Som")
    public void elUsuarioSeEncuentraEnOnSom() {
        Driver.getDriver().get("https://www.cinesimperial.com/index.php?option=com_k2&view=item&layout=item&id=12&Itemid=118");
    }

    @When("el mapa se ha insertado")
    public void elMapaSeHaInsertado() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Then("el elemento canvas esta presente")
    public void elElementoCanvasEstaPresente() {
        Assert.assertNotNull(Driver.getDriver().findElement(By.className("bt-googlemaps")));
    }

    @When("el mapa ha cargado datos")
    public void elMapaHaCargadoDatos() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Then("el canvas no muestra ningun error")
    public void elCanvasNoMuestraNingunError() {
        Assert.assertNull(Driver.getDriver().findElement(By.className("gm-err-container")));
    }
}
