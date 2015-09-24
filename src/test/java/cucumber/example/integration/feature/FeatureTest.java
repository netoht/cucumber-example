package cucumber.example.integration.feature;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    glue = "cucumber.example.integration.step2",
    features = "classpath:feature_files/",
    plugin = { "pretty", "html: target/cucumber.html", "json: target/cucumber.json" },
    tags = { "~@Ignore" },
    strict = true
)
public class FeatureTest {
}