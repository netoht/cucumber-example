package cucumber.example.integration.feature;

import org.junit.runner.*;

import cucumber.api.*;
import cucumber.api.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
    glue = "cucumber.example.integration.step",
    features = "classpath:feature_files/",
    format = { "pretty", "html: target/cucumber.html", "json: target/cucumber.json" },
    tags = { "~@Ignore" },
    strict = true
)
public class FeatureTest {
}