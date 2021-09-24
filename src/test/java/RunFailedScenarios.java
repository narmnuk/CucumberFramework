import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/RerunFailed.html", "rerun:target/failed-scenarios/RerunFailed.txt"},
        features = "@target/failed-scenarios/RerunFailed.txt",
        glue = {"steps"}
)

public class RunFailedScenarios {

}