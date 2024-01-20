import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/features/MovieListings.feature",
    glue = "steps",
    plugin = {"pretty", "html:target/cucumber"},
    monochrome = true
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {



}
