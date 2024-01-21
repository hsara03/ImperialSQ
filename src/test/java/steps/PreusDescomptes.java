package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import steps.Driver;

import java.util.List;

public class PreusDescomptes {

    @Given("el usuario esta en la pagina principal de precios y descuentos")
    public void elUsuarioEstaEnLaPaginaPrincipalDePreciosYDescuentos() {
        Driver.getDriver().get("https://www.cinesimperial.com/index.php?option=com_k2&view=item&layout=item&id=15&Itemid=117");
    }

    @Then("los descuentos se muestran correctamente")
    public void losDescuentosSeMuestranCorrectamente() {
        List<WebElement> elements =  Driver.getDriver().findElements(By.cssSelector(".contentpaneopen tbody tr td table tbody tr"));
        for(WebElement row : elements) {
            List<WebElement> cell = row.findElements(By.className("td"));
            if(cell.size()>=3 && !cell.get(1).getText().trim().isEmpty()){
                Assert.assertTrue(cell.get(2).getText().matches("/^[0-9]+\\,[0-9]{2} €$/"));
            }
        }
    }
}
