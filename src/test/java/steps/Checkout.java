package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;





public class Checkout {

    WebElement acceptButton = null;
    WebElement cancelButton = null;
    WebElement emailInput = null;
    WebElement passwordInput = null;

    @Given("el usuario está en la página principal de Imperial")
    public void elUsuarioEstáEnLaPáginaPrincipalDe() {
        Driver.getDriver().get("https://www.cinesimperial.com/index.php");
    }

    @When("el usuario selecciona la primera película disponible")
    public void elUsuarioSeleccionaLaPrimeraPelículaDisponible() throws InterruptedException {
        Thread.sleep(1000);
        WebElement primeraPelicula = Driver.getDriver().findElement(By.cssSelector("div.peli-item:first-of-type"));
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(primeraPelicula).perform();
        primeraPelicula.findElement(By.cssSelector("a")).click();
    }

    @And("el usuario escoge la primera sesión disponible")
    public void elUsuarioEscogeLaPrimeraSesiónDisponible() throws InterruptedException{
        Thread.sleep(5000);
        List<WebElement> botonesHora = Driver.getDriver().findElements(By.cssSelector("button.btn"));
        WebElement ultimaHoraDisponible = botonesHora.get(botonesHora.size() - 1);
        ultimaHoraDisponible.click();
    }

    @And("el usuario indica {string} entradas")
    public void elUsuarioIndicaEntradas(String numEntradas) throws InterruptedException{
        Thread.sleep(1000);
        WebElement selectElement = Driver.getDriver().findElement(By.id("numentrades"));
        Select select = new Select(selectElement);
        select.selectByValue(numEntradas);
    }

    @And("el usuario selecciona que tiene tarjeta de fidelidad")
    public void elUsuarioSeleccionaQueTieneTarjetaDeFidelidad() throws InterruptedException{
        Thread.sleep(1000);
        WebElement botonSi = Driver.getDriver().findElement(By.xpath("//button[contains(.,'Sí')]"));
        botonSi.click();

    }

    @And("el usuario introduce su correo electrónico y contraseña de fidelidad incorrecta")
    public void elUsuarioIntroduceSuCorreoElectrónicoYContraseñaDeFidelidad() throws InterruptedException{
        Thread.sleep(1000);
        if(passwordInput == null || emailInput == null){
            List<WebElement> inputs = Driver.getDriver().findElements(By.cssSelector(".v-main__wrap .dlgInput .v-input .v-input__control .v-input__slot .v-text-field__slot input"));
            Assert.assertEquals(inputs.size(), 2);
            emailInput = inputs.get(0);
            passwordInput = inputs.get(1);
        }

        emailInput.clear();
        emailInput.sendKeys("test@gmail.com");

        passwordInput.clear();
        passwordInput.sendKeys("1234");

        List<WebElement> botonCerrarAlerta = Driver.getDriver().findElements(By.className("dlgBtn"));
        if(cancelButton == null || acceptButton == null){
            acceptButton = null;
            for (WebElement element : botonCerrarAlerta){
                if (element.getText().trim().contains("No") || element.getText().trim().contains("no")) {
                    cancelButton = element;
                    continue;
                }
                acceptButton = element;
            }
        }
        Assert.assertNotNull(acceptButton);
        acceptButton.click();
    }

    @Then("sale error {string}")
    public void saleErrorDeTargetaOContrasenyaIncorrecta(String arg0) throws InterruptedException{
        Thread.sleep(1000);
        Assert.assertNotNull(Driver.getDriver().findElement(By.cssSelector(".v-overlay.v-overlay--active.theme--dark")), "Alerta no activa");
    }

    @And("salir del error")
    public  void salirDelError() throws InterruptedException {
        Thread.sleep(1000);
        WebElement botonCerrarAlerta = Driver.getDriver().findElement(By.id("alert-tancar"));
        botonCerrarAlerta.click();
    }

    @And("el usuario clica directamente Accepta")
    public  void elUsuarioClicaDirectamenteAccepta() throws InterruptedException{
        emailInput.clear();
        passwordInput.clear();
        Thread.sleep(1000);
        acceptButton.click();
    }

    @And("clica no gracias")
    public void clicaNoGracias() throws InterruptedException {
        cancelButton.click();
        Thread.sleep(1000);
    }

    @And("el usuario clica a entrar vals")
    public void elUsuarioClicaAEntrarVals() {
        Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Entrar vals')]")).click();
    }

    @And("clica Validar")
    public void clicaValidar() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.cssSelector(".mt-0.col-4 button")).click();
    }

    @And("introduce datos vale")
    public void entroduceDatosVale() {
        Driver.getDriver().findElement(By.cssSelector(".mt-5.col.col-8  .v-input .v-input__control .v-input__slot .v-text-field__slot input")).sendKeys("123");
    }

    @And("cancela introduccion de vales")
    public void cancelaIntroduccionDeVales() {
        Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Acceptar')]")).click();
    }

    @And("clica seguent")
    public void clicaSeguent() throws InterruptedException {
        Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Següent')]")).click();
        Thread.sleep(5000);
    }

    @And("el usuario completa los datos de contacto")
    public void elUsuarioCompletaLosDatosDeContacto(){
        List<WebElement> inputs = Driver.getDriver().findElements(By.cssSelector(".col-8 .v-input .v-input__control .v-input__slot .v-text-field__slot input"));
        Assert.assertTrue(inputs.size()>=5, "faltan inputs");
        WebElement nombre = inputs.get(0);
        WebElement apellido = inputs.get(1);
        WebElement email = inputs.get(2);
        WebElement email2 = inputs.get(3);
        WebElement phone = inputs.get(4);
        nombre.sendKeys(Utils.generateRandomString(6));
        apellido.sendKeys(Utils.generateRandomString(6));
        String emailTxt = Utils.generateRandomEmail();
        email.sendKeys(emailTxt);
        email2.sendKeys(emailTxt);
        phone.sendKeys(Utils.randomPhoneNumber());
    }

    @And("el usuario lee las condiciones de compra")
    public void elUsuarioLeeLasCondicionesDeCompra() throws InterruptedException {
        Driver.getDriver().findElement(By.linkText("Accepto les condicions de compra")).click();
        Thread.sleep(5000);
    }

    @And("el usuario clica a tornar")
    public void elUsuarioClicaATornar() throws InterruptedException {
        Driver.getDriver().findElement(By.xpath("//span[contains(text(),'TORNAR')]")).click();
        Thread.sleep(5000);
    }

    @And("el usuario acepta las condiciones de compra")
    public void elUsuarioAceptaLasCondicionesDeCompra() throws InterruptedException {
        goToBottom();
        List<WebElement> elements = Driver.getDriver().findElements(By.className("v-input--selection-controls__ripple"));
        Assert.assertTrue(elements.size()>=2, "faltan checkboxes");
        elements.get(1).click();
    }

    @And("el usuario selecciona la opción de Tornar")
    public void elUsuarioSeleccionaLaOpciónDeTornar() {
        WebElement botonTornar = Driver.getDriver().findElement(By.linkText("TORNAR"));
        botonTornar.click();
    }

    @Then("el usuario regresa a la página anterior en el proceso de compra")
    public void elUsuarioRegresaALaPaginaAnterior() {
        String expectedUrl = "https://www.cinesimperial.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl), "URL does not match expected Facebook page URL.");
    }

    @And("el usuario clica pagar")
    public void elUsuarioClicaPagar() throws InterruptedException {
        goToBottom();
        List<WebElement> buttons = Driver.getDriver().findElements(By.cssSelector(".row.justify-center button"));
        Assert.assertEquals(buttons.size(), 2);
        buttons.get(1).click();
    }

    private void goToBottom() throws InterruptedException {
        ((JavascriptExecutor) Driver.getDriver())
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);
    }

    @And("el usuario se redirige a la pagina de pago")
    public void elUsuarioSeRedirigeALaPaginaDePago() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://pps.ecopaynet.com/Payment.aspx");
    }

    @And("el usuario inicia el proceso de compra")
    public void elUsuarioIniciaElProcesoDeCompra() {
        WebElement seguent = Driver.getDriver().findElement(By.cssSelector("input.buto[type='submit'][value='SEGÜENT']"));
        seguent.click();
    }

}
