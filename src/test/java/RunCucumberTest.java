package test.java;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources",
    glue = "test.java",
    plugin = {"pretty", "html:target/cucumber"},
    monochrome = true
)
public class RunCucumberTest {
  // empty
}
