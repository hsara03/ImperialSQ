package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class footer {

    @When("el usuario hace clic en el enlace {string} en el footer")
    public void elUsuarioHaceClicEnElEnlaceEnElFooter(String arg0) {
        WebElement legalNoticeLink = Driver.getDriver().findElement(By.cssSelector("footer a[href*='item&layout=item&id=26&Itemid=162']"));
        legalNoticeLink.click();
    }

    @Then("el usuario debería ser redirigido a la página de {string}")
    public void elUsuarioDeberíaSerRedirigidoALaPáginaDe(String arg0) {
        String expectedUrlContains = "Itemid=162";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlContains), "El usuario no ha sido redirigido a la página de Avis legal correctamente");
    }
}
