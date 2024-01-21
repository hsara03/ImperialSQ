package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;


import java.time.Duration;


public class PointCheck {

    @Then("se muestra la lista de premios disponibles con su coste en puntos")
    public void seMuestraElSaldoDePuntosDelUsuario() {
        String expectedUrl = "https://www.cinesimperial.com/index.php?option=com_cines&task=premis";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "No se redirigió a la URL esperada para 'Consultar Premis'.");

        WebElement premiosTable = Driver.getDriver().findElement(By.cssSelector("div#rt-mainbody table"));
        Assert.assertNotNull(premiosTable, "La tabla de premios no está presente.");

        List<WebElement> filas = premiosTable.findElements(By.cssSelector("tr"));
        Assert.assertFalse(filas.isEmpty(), "La lista de premios está vacía.");

        for (WebElement fila : filas) {
            if(!fila.findElements(By.cssSelector("[colspan='4']")).isEmpty()) continue;
            List<WebElement> componentsFila = fila.findElements(By.className("lletrespremis"));

            Assert.assertEquals(componentsFila.size(), 2, "El premio no tiene un componente para su nombre o para su cantidad de puntos");

            WebElement premio = componentsFila.get(0);
            WebElement puntosElement = componentsFila.get(1);

            String nombrePremio = premio.getText().trim();
            Assert.assertFalse(nombrePremio.isEmpty(), "Hay un premio sin nombre.");

            String puntos = puntosElement.getText().replace("punts", "").trim();
            Assert.assertFalse(puntos.isEmpty(), "El premio '" + nombrePremio + "' no tiene un costo en puntos asociado.");

            NumberFormatException errorNumber = null;
            try {
                Integer.parseInt(puntos);
            } catch (NumberFormatException exception){
                errorNumber = exception;
            }

            Assert.assertNull(errorNumber, "la cantidad de puntos no es numerica");
        }
    }

    @Then("se muestra un mensaje de error indicando datos incorrectos")
    public void seMuestraUnMensajeDeErrorIndicandoDatosIncorrectos() {
        String expectedUrl = "https://www.cinesimperial.com/index.php?option=com_cines&task=puntspost";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "No se redirigió a la URL esperada después de enviar datos incorrectos.");

        WebElement errorMessage = Driver.getDriver().findElement(By.cssSelector("span[style='color:red;']"));
        String expectedErrorMessage = "Dades targeta o Pin incorrectes";
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "El mensaje de error no es el esperado.");
    }

    @When("el usuario introduce un número de tarjeta y contraseña incorrectos")
    public void elUsuarioIntroduceUnNúmeroDeTarjetaYContraseñaIncorrectos() {
        WebElement numeroTarjetaInput = Driver.getDriver().findElement(By.name("targetaclient"));
        numeroTarjetaInput.sendKeys("123456");
        WebElement passwordInput = Driver.getDriver().findElement(By.name("password"));
        passwordInput.sendKeys("123456");
    }

    @When("el usuario introduce solo su número de tarjeta")
    public void elUsuarioIntroduceSoloSuNúmeroDeTarjeta() {
        WebElement numeroTarjetaInput = Driver.getDriver().findElement(By.name("targetaclient"));
        numeroTarjetaInput.sendKeys("123456");
        WebElement passwordInput = Driver.getDriver().findElement(By.name("password"));
        passwordInput.clear();
    }

    @Then("se muestra un mensaje de error solicitando datos numéricos para el número de tarjeta y contraseña")
    public void seMuestraUnMensajeDeErrorSolicitandoDatosNuméricosParaElNúmeroDeTarjetaYContraseña() throws InterruptedException {
        boolean found = false;
        try {
            Thread.sleep(1000);
            Alert alert = Driver.getDriver().switchTo().alert();
            found = true; // exception will be thrown if not reached
            String alertText = alert.getText();
            alert.accept();
            Assert.assertEquals("El camp Número tarjeta ha de ser numèric  ", alertText);
        } catch (UnhandledAlertException exception) {
            found=true;
        }
        Assert.assertTrue(found, "No aparecio ningun error");
    }

    @Then("se muestra un mensaje de error solicitando una contraseña")
    public void seMuestraUnMensajeDeErrorSolicitandoUnaContraseña() throws InterruptedException{
        boolean found = false;
        try {
            Thread.sleep(1000);
            Alert alert = Driver.getDriver().switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            Assert.assertEquals("El camp password ha de tenir algun valor i ha de ser numèric  ", alertText);
        } catch (UnhandledAlertException exception) {
            found=true;
        }
        Assert.assertTrue(found, "No aparecio ningun error");
    }

    @Given("el usuario está en la sección {string}")
    public void elUsuarioEstáEnLaSección(String section) {
        Driver.getDriver().get("https://www.cinesimperial.com/index.php?option=com_cines&task=punts&Itemid=160");
    }

    @When("el usuario hace clic en Consultar Punts ")
    public void elUsuarioHaceClicEnSinIntroducirDatos()  {
        Driver.getDriver().findElement(By.cssSelector("input[type='submit'][value='Consultar Punts']")).click();
    }

    @And("el usuario hace clic en Consultar Punts")
    public void elUsuarioHaceClicEn() {
        Driver.getDriver().findElement(By.cssSelector("input[type='submit'][value='Consultar Punts']")).click();
    }

    @When("el usuario introduce solo su contraseña")
    public void elUsuarioIntroduceSoloSuContraseña() {
        WebElement passwordInput= Driver.getDriver().findElement(By.name("password"));
        passwordInput.sendKeys("123456");
    }

    @Then("se muestra un mensaje de error solicitando un número de tarjeta numérico")
    public void seMuestraUnMensajeDeErrorSolicitandoUnNúmeroDeTarjetaNumérico() throws  InterruptedException{
        boolean found = false;
        try {
            Thread.sleep(1000);
            Alert alert = Driver.getDriver().switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            Assert.assertEquals("El camp Número tarjeta ha de ser numèric  ", alertText);
        } catch (UnhandledAlertException exception) {
            found=true;
        }
        Assert.assertTrue(found, "No aparecio ningun error");
    }


    @When("el usuario hace clic en Consultar Premis")
    public void elUsuarioSelecciona() {
        Driver.getDriver().findElement(By.cssSelector("a.button[href*='task=premis']")).click();
    }

}
