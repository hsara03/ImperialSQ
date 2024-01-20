package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class nav {
    @When("el usuario hace clic en el logo de Cines Imperial")
    public void elUsuarioHaceClicEnElLogoDeCinesImperial() {
        Driver.getDriver().findElement(By.cssSelector("[alt='logo']")).click();
    }

    @Then("el usuario debería ser redirigido a la página principal de https:\\/\\/www.cinesimperial.com\\/")
    public void elUsuarioDeberíaSerRedirigidoALaPáginaPrincipalDeHttpsWwwCinesimperialCom() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.cinesimperial.com/index.php");
    }

    @When("el usuario hace clic en el enlace Cartellera")
    public void elUsuarioHaceClicEnElEnlaceCartellera() {
        Driver.getDriver().findElement(By.partialLinkText("Cartellera")).click();
    }

    @Then("el usuario debería ser redirigido a la página de Cartellera")
    public void elUsuarioDeberíaSerRedirigidoALaPáginaDeCartellera() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.cinesimperial.com/index.php?option=com_cines&Itemid=101");
    }

    @When("el usuario hace clic en el enlace Promocions")
    public void elUsuarioHaceClicEnElEnlacePromocions() {
        Driver.getDriver().findElement(By.partialLinkText("Promocions")).click();
    }

    @Then("el usuario debería ser redirigido a la página de Promocions")
    public void elUsuarioDeberíaSerRedirigidoALaPáginaDePromocions() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.cinesimperial.com/index.php?option=com_k2&view=itemlist&layout=category&task=category&id=1&Itemid=156");
    }

    @When("el usuario hace clic en el enlace Esdeveniments")
    public void elUsuarioHaceClicEnElEnlaceEsdeveniments() {
        Driver.getDriver().findElement(By.partialLinkText("Esdeveniments")).click();
    }

    @Then("el usuario debería ser redirigido a la página de Esdeveniments")
    public void elUsuarioDeberíaSerRedirigidoALaPáginaDeEsdeveniments() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.cinesimperial.com/index.php?option=com_cines&task=esdeveniments&Itemid=158");
    }

    @When("el usuario hace clic en el enlace Tarjeta Imperial Cinema")
    public void elUsuarioHaceClicEnElEnlaceTarjetaImperialCinema() throws InterruptedException {
        Driver.getDriver().findElement(By.partialLinkText("Tarjeta Imperial Cinema")).click();
        Thread.sleep(1000);
    }

    @Then("el usuario debería ver las opciones del menú Tarjeta Imperial Cinema")
    public void elUsuarioDeberíaVerLasOpcionesDelMenúTarjetaImperialCinema() {
        Assert.assertNotNull(Driver.getDriver().findElement(By.partialLinkText("Avantatges Club")));
        Assert.assertNotNull(Driver.getDriver().findElement(By.partialLinkText("Punts i premis")));
        Assert.assertNotNull(Driver.getDriver().findElement(By.partialLinkText("Formulari d'alta")));
    }

    @And("el usuario hace clic en Avantatges Club")
    public void elUsuarioHaceClicEnAvantatgesClub() {
        Driver.getDriver().findElement(By.partialLinkText("Avantatges Club")).click();
    }

    @Then("el usuario debería ser redirigido a la página de Avantatges Club")
    public void elUsuarioDeberíaSerRedirigidoALaPáginaDeAvantatgesClub() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.cinesimperial.com/index.php?option=com_k2&view=item&layout=item&id=13&Itemid=159");
    }

    @And("el usuario hace clic en Punts i premis")
    public void elUsuarioHaceClicEnPuntsIPremis() {
        Driver.getDriver().findElement(By.partialLinkText("Punts i premis")).click();
    }

    @Then("el usuario debería ser redirigido a la página de Punts i premis")
    public void elUsuarioDeberíaSerRedirigidoALaPáginaDePuntsIPremis() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.cinesimperial.com/index.php?option=com_cines&task=punts&Itemid=160");
    }

    @And("el usuario hace clic en Formulari d'alta")
    public void elUsuarioHaceClicEnFormulariDAlta() {
        Driver.getDriver().findElement(By.partialLinkText("Formulari d'alta")).click();
    }

    @Then("el usuario debería ser redirigido a la página de Formulari d'alta")
    public void elUsuarioDeberíaSerRedirigidoALaPáginaDeFormulariDAlta() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.cinesimperial.com/index.php?option=com_cines&task=alta&Itemid=161");
    }

    @When("el usuario hace clic en el enlace Preus i Descomptes")
    public void elUsuarioHaceClicEnElEnlacePreusIDescomptes() {
        Driver.getDriver().findElement(By.partialLinkText("Preus i Descomptes")).click();
    }

    @Then("el usuario debería ser redirigido a la página de Preus i Descomptes")
    public void elUsuarioDeberíaSerRedirigidoALaPáginaDePreusIDescomptes() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.cinesimperial.com/index.php?option=com_k2&view=item&layout=item&id=15&Itemid=117");
    }

    @When("el usuario hace clic en el enlace On som")
    public void elUsuarioHaceClicEnElEnlaceOnSom() {
        Driver.getDriver().findElement(By.partialLinkText("On som")).click();
    }

    @Then("el usuario debería ser redirigido a la página de On som")
    public void elUsuarioDeberíaSerRedirigidoALaPáginaDeOnSom() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.cinesimperial.com/index.php?option=com_k2&view=item&layout=item&id=12&Itemid=118");
    }
}
