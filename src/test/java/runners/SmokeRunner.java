package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Dashboard.feature",
        //glue is where we can find implementation for gherkin steps
        //we provide the path of package for steps
        glue = "steps",
        // if we set dry run to true, it will quickly check if all gherkin steps are implemented or not
        //if it's true, no actual execution happens
        dryRun = false,
        //monochrome allows the console output to become more easily readable by removing unreadable characters
        monochrome = true,
        //if strict is set to true, if cucumber finds any unimplemented steps at execution time, it will give an
        //error and stop execution.

        //tags will identify the scenarios based on tags we provide (ex: smoke, regression, etc)
        // we can add multiple tags in runner class to execute scenarios that belong to different tags
        // can do and, or, "," (ex: @smoke and @regression)
        tags = "@dashboardTabs",
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json", "rerun:target/failed.txt"}
)

public class SmokeRunner {

}
