import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import steps.Driver;

public class RunTests extends AbstractTestNGCucumberTests {

    RunTests(){
        // descomentar si se desea pobar con otro buscador. Driver.setDefaultDriver(Driver.EDGE);
    }

    @CucumberOptions(features = "src/test/java/features/Checkout.feature", glue = "steps")
    public static class CheckoutTest extends RunTests {}

    @CucumberOptions(features = "src/test/java/features/Esdeveniments.feature", glue = "steps")
    public static class EsdevenimentsTest extends RunTests {}

    @CucumberOptions(features = "src/test/java/features/Footer.feature", glue = "steps")
    public static class FooterTest extends RunTests {}

    @CucumberOptions(features = "src/test/java/features/Homepage.feature", glue = "steps")
    public static class HomepageTest extends RunTests {}

    @CucumberOptions(features = "src/test/java/features/MapView.feature", glue = "steps")
    public static class MapViewTest extends RunTests {}

    @CucumberOptions(features = "src/test/java/features/MovieListings.feature", glue = "steps")
    public static class MovieListingsTest extends RunTests {}

    @CucumberOptions(features = "src/test/java/features/MovieDetails.feature", glue = "steps")
    public static class MovieDetailsTest extends RunTests {}

    @CucumberOptions(features = "src/test/java/features/Nav.feature", glue = "steps")
    public static class NavTest extends RunTests {}

    @CucumberOptions(features = "src/test/java/features/PointCheck.feature", glue = "steps")
    public static class PointCheckTest extends RunTests {}

    @CucumberOptions(features = "src/test/java/features/PreusDescomptes.feature", glue = "steps")
    public static class PreusDescomptesTest extends RunTests {}

    @CucumberOptions(features = "src/test/java/features/SignUp.feature", glue = "steps")
    public static class SignUpTest extends RunTests {}

    @CucumberOptions(features = "src/test/java/features/TheaterFeatures.feature", glue = "steps")
    public static class TheaterFeaturesTest extends RunTests {}
}

