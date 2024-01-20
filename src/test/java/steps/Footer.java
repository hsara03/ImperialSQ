package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Footer {

    @When("el usuario hace clic en el enlace 'Avis legal' en el footer")
    public void el_usuario_hace_clic_en_el_enlace_Avis_legal_en_el_footer() {
        WebElement legalNoticeLink = CommonSteps.getDriver().findElement(By.cssSelector("footer a[href*='item&layout=item&id=26&Itemid=162']"));
        legalNoticeLink.click();
    }

    @Then("el usuario debería ser redirigido a la página de 'Avis legal'")
    public void el_usuario_deberia_ser_redirigido_a_la_pagina_de_Avis_legal() {

        String expectedUrlContains = "Itemid=162";
        String actualUrl = CommonSteps.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlContains), "El usuario no ha sido redirigido a la página de Avis legal correctamente");
    }
}
