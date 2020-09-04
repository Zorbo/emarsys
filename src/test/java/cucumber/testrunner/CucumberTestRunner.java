package cucumber.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources/features",
                 glue = "cucumber",
                 plugin = {"pretty", "html:target/test_result/html-result/",
                     "json:target/test_result/test-report.json",
                     "junit:target/test_result/result.xml"},
                 tags = {"@DueDate"},
                 monochrome = true)
public class CucumberTestRunner {

}
