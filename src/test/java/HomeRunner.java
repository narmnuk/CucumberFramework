import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/HomeRunner.html", "rerun:target/failed-scenarios/HomeRunner.txt"},
        features = "src/main/resources/features/Home.feature",
        glue = {"steps"},
        stepNotifications = true
)

public class HomeRunner {

}