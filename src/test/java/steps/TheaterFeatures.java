package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TheaterFeatures {
    @When("el usuario navega a la sección Index")
    public void elUsuarioNavegaALaSecciónIndex() {
        Driver.getDriver().get("https://www.cinesimperial.com/index.php");
    }

    @Then("las opciones pertinentes se muestran en la parte inferior")
    public void lasOpcionesPertinentesSeMuestranEnLaParteInferior() throws InterruptedException {
        String[] selectors = {"#rt-extension .rt-omega .rt-block .module-surround .module-content div .sprocket-tabs", "#rt-content-bottom .rt-omega .rt-block .module-surround .module-content div .sprocket-tabs"};
        boolean found = false;
        for (String selector : selectors) {
            if (!Driver.getDriver().findElements(By.cssSelector(selector)).isEmpty()) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
    }

    @And("las opciones pueden ser alternadas")
    public void lasOpcionesPuedenSerAlternadas() throws InterruptedException {
        for (int i = 0; i < getTabs().size(); i++) {
            getTabs().get(i).click();
            Assert.assertEquals(getActiveTab(), i);
        }
    }

    private List<WebElement> getTabs(){
        return Driver.getDriver().findElements(By.cssSelector(".sprocket-tabs-nav li"));
    }

    private int getActiveTab(){
        List<WebElement> elements = getTabs();
        for (int i = 0; i < elements.size(); i++) {
            if(elements.get(i).getAttribute("class").contains("active")) return i;
        }
        return -1;
    }

    @When("el usuario navega a la sección Promocions")
    public void elUsuarioNavegaALaSecciónPromocions() {
        Driver.getDriver().get("https://www.cinesimperial.com/index.php?option=com_k2&view=itemlist&layout=category&task=category&id=1&Itemid=156");
    }

    @When("el usuario navega a la sección Esdeveniments")
    public void elUsuarioNavegaALaSecciónEsdeveniments() {
        Driver.getDriver().get("https://www.cinesimperial.com/index.php?option=com_cines&task=esdeveniments&Itemid=158");
    }

    @Then("las opciones pertinentes se muestran en la parte derecha")
    public void lasOpcionesPertinentesSeMuestranEnLaParteDerecha() {
        Assert.assertNotNull(Driver.getDriver().findElement(By.cssSelector("#rt-sidebar-a .rt-block .module-surround .module-content div .sprocket-tabs")));
    }

    @When("el usuario navega a la sección Avantatges Club")
    public void elUsuarioNavegaALaSecciónAvantatgesClub() {
        Driver.getDriver().get("https://www.cinesimperial.com/index.php?option=com_k2&view=item&layout=item&id=13&Itemid=159");
    }

    @When("el usuario navega a la sección Punts i Premis")
    public void elUsuarioNavegaALaSecciónPuntsIPremis() {
        Driver.getDriver().get("https://www.cinesimperial.com/index.php?option=com_cines&task=punts&Itemid=160");
    }

    @When("el usuario navega a la sección Formulari d'Alta")
    public void elUsuarioNavegaALaSecciónFormulariDAlta() {
        Driver.getDriver().get("https://www.cinesimperial.com/index.php?option=com_cines&task=alta&Itemid=161");
    }

    @When("el usuario navega a la sección Preus i descomptes")
    public void elUsuarioNavegaALaSecciónPreusIDescomptes() {
        Driver.getDriver().get("https://www.cinesimperial.com/index.php?option=com_k2&view=item&layout=item&id=15&Itemid=117");
    }

    @When("el usuario navega a la sección On Som")
    public void elUsuarioNavegaALaSecciónOnSom() {
        Driver.getDriver().get("https://www.cinesimperial.com/index.php?option=com_k2&view=item&layout=item&id=12&Itemid=118");
    }

    @When("el usuario navega a la sección Avis legal")
    public void elUsuarioNavegaALaSecciónAvisLegal() {
        Driver.getDriver().get("https://www.cinesimperial.com/index.php?option=com_k2&view=item&layout=item&id=26&Itemid=162");
    }

    @Then("las opciones no se muestran")
    public void lasOpcionesNoSeMuestran() {
        Assert.assertTrue(Driver.getDriver().findElements(By.cssSelector(".sprocket-tabs")).isEmpty());
    }
}
