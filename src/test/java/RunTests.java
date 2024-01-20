import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class RunTests extends AbstractTestNGCucumberTests {
    @CucumberOptions(features = "src/test/java/features/footer.feature", glue = "steps")
    public static class FooterTest extends RunTests {}

    @CucumberOptions(features = "src/test/java/features/homepage.feature", glue = "steps")
    public static class HomepageTest extends RunTests {}

    @CucumberOptions(features = "src/test/java/features/mapView.feature", glue = "steps")
    public static class MapViewTest extends RunTests {}

    @CucumberOptions(features = "src/test/java/features/movieListings.feature", glue = "steps")
    public static class MovieListingsTest extends RunTests {}

    @CucumberOptions(features = "src/test/java/features/nav.feature", glue = "steps")
    public static class NavTest extends RunTests {}

    @CucumberOptions(features = "src/test/java/features/theaterFeatures.feature", glue = "steps")
    public static class TheaterFeaturesTest extends RunTests {}
}

