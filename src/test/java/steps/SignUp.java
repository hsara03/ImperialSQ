package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Random;

public class SignUp {

    private static String dni = null;
    private static String email = null;

    @Given("el usuario está en la página principal de Formulari d'alta")
    public void elUsuarioEstáEnLaPáginaPrincipalDeFormulariDAlta() throws InterruptedException {
        Driver.getDriver().get("https://www.cinesimperial.com/index.php?option=com_cines&task=alta&Itemid=161");
        Thread.sleep(1000);
    }

    @Then("se muestra un mensaje de error")
    public void seMuestraUnMensajeDeError() throws InterruptedException {
        boolean found = false;
        try {
            Thread.sleep(1000);
            Alert alert = Driver.getDriver().switchTo().alert();
            found = true;
            alert.accept();
        } catch (UnhandledAlertException exception) {
            found=true;
        }
        Assert.assertTrue(found, "No aparecio ningun error");
    }

    private static char calculateDNILetter(int dniDigits) {
        char[] dniLetters = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int remainder = dniDigits % 23;
        return dniLetters[remainder];
    }

    private static String getEmail(boolean fresh) {
        if(email != null && !fresh) return email;
        email = Utils.generateRandomEmail();
        return email;
    }

    @When("el no introduce ningun dato")
    public void elNoIntroduceNingunDato() {
        // dummy
    }

    @And("el usuario envia el formulario")
    public void elUsuarioEnviaElFormulario() {
        Driver.getDriver().findElement(By.id("enviar")).click();
    }

    @When("el usuario introduce su nombre")
    public void elUsuarioIntroduceSuNombre() {
        WebElement inputElement = Driver.getDriver().findElement(By.id("nombre"));
        inputElement.clear();
        inputElement.sendKeys("Test Username");
    }

    @When("el usuario introduce mal el DNI")
    public void elUsuarioIntroduceMalElDNI() {
        WebElement inputElement = Driver.getDriver().findElement(By.id("numero"));
        inputElement.clear();
        inputElement.sendKeys("123");
    }

    @When("el usuario introduce un DNI valido")
    public void elUsuarioIntroduceUnDNIValido() {
        WebElement inputElement = Driver.getDriver().findElement(By.id("numero"));
        inputElement.clear();
        inputElement.sendKeys(generateRandomDNI(true));
    }

    @When("el usuario introduce un DNI valido reutilizado")
    public void elUsuarioIntroduceUnDNIValidoReutilizado() {
        WebElement inputElement = Driver.getDriver().findElement(By.id("numero"));
        inputElement.clear();
        inputElement.sendKeys(generateRandomDNI(false));
    }

    private static String generateRandomDNI(boolean fresh) {
        if(dni!=null && !fresh) return dni;
        Random random = new Random();
        int randomNumber = random.nextInt(90000000) + 10000000;
        char dniLetter = calculateDNILetter(randomNumber);
        dni = String.format("%d%c", randomNumber, dniLetter);
        return dni;
    }

    @When("el usuario introduce la fecha de nacimiento")
    public void elUsuarioIntroduceLaFechaDeNacimiento() {
        new Select(Driver.getDriver().findElement(By.name("dia"))).selectByValue(String.valueOf((int) Math.floor(Math.random()*27)));
        new Select(Driver.getDriver().findElement(By.name("mes"))).selectByValue(String.valueOf((int) Math.floor(Math.random()*11+1)));
        WebElement inputElement = Driver.getDriver().findElement(By.name("ano"));
        inputElement.clear();
        inputElement.sendKeys(String.valueOf((int) (1970+Math.floor(Math.random()*(2024-1970)))));
    }

    @When("el usuario introduce mal el email")
    public void elUsuarioIntroduceMalElEmail() {
        WebElement inputElement = Driver.getDriver().findElement(By.id("email"));
        inputElement.clear();
        inputElement.sendKeys("aaa");
    }

    @When("el usuario introduce un email valido")
    public void elUsuarioIntroduceUnEmailValido() {
        WebElement inputElement = Driver.getDriver().findElement(By.id("email"));
        inputElement.clear();
        inputElement.sendKeys(getEmail(true));
    }

    @When("el usuario introduce un email valido reutilizado")
    public void elUsuarioIntroduceUnEmailValidoReutiliado() {
        WebElement inputElement = Driver.getDriver().findElement(By.id("email"));
        inputElement.clear();
        inputElement.sendKeys(getEmail(false));
    }

    @When("el usuario introduce el telefono")
    public void elUsuarioIntroduceElTelefono() {
        WebElement inputElement = Driver.getDriver().findElement(By.id("telefono"));
        inputElement.clear();
        inputElement.sendKeys(Utils.randomPhoneNumber());
    }

    @When("el usuario introduce la direccion")
    public void elUsuarioIntroduceLaDireccion() {
        WebElement inputElement = Driver.getDriver().findElement(By.id("direccion"));
        inputElement.clear();
        inputElement.sendKeys(Utils.generateRandomString(6));
    }

    @When("el usuario introduce mal el CP")
    public void elUsuarioIntroduceMalElCP() {
        WebElement inputElement = Driver.getDriver().findElement(By.id("codigoPostal"));
        inputElement.clear();
        inputElement.sendKeys("1");
    }

    @When("el usuario introduce un CP valido")
    public void elUsuarioIntroduceUnCPValido() {
        WebElement inputElement = Driver.getDriver().findElement(By.id("codigoPostal"));
        inputElement.clear();
        inputElement.sendKeys(String.valueOf(Utils.generateRandomNumber(5)));
    }

    @When("el usuario introduce la localidad")
    public void elUsuarioIntroduceLaLocalidad() {
        WebElement inputElement = Driver.getDriver().findElement(By.id("localidad"));
        inputElement.clear();
        inputElement.sendKeys(Utils.generateRandomString(6));
    }

    @When("el usuario introduce la provincia")
    public void elUsuarioIntroduceLaProvincia() {
        WebElement inputElement = Driver.getDriver().findElement(By.id("provincia"));
        inputElement.clear();
        inputElement.sendKeys(Utils.generateRandomString(6));
    }

    @Then("el formulario se envia correctamente")
    public void elFormularioSeEnviaCorrectamente() throws InterruptedException {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.cinesimperial.com/index.php?option=com_cines&task=altapost");
        Assert.assertTrue(Driver.getDriver().findElement(By.className("component-content")).getText().contains("Dades guardades correctament"));
    }

    @Then("el formulario indica duplicado")
    public void elFormularioIndicaDuplicado() throws InterruptedException {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.cinesimperial.com/index.php?option=com_cines&task=altapost");
        Assert.assertTrue(Driver.getDriver().findElement(By.className("component-content")).getText().contains("Ja existeix un usuari"));
    }
}
