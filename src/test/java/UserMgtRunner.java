import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/UserMgtRunner.html", "rerun:target/failed-scenarios/UserMgtRunner.txt"},
        features = "src/main/resources/features/UserMgt.feature",
        glue = {"steps"},
        stepNotifications = true,
        dryRun = false
)

public class UserMgtRunner {

}