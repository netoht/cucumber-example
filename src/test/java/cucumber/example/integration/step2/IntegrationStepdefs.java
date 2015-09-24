package cucumber.example.integration.step2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.Scenario;
import cucumber.api.java8.Pt;
import cucumber.example.Application;

@ContextConfiguration(classes = Application.class)
public class IntegrationStepdefs implements Pt {

    private final WebDriver driver = new FirefoxDriver();

    private final GoogleSearchPage googleSearchPage = PageFactory.initElements(driver, GoogleSearchPage.class);

    public IntegrationStepdefs() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Dado("^que o usuário esteja no site \"(.*?)\"$", (String url) -> {
            googleSearchPage.visit();
        });

        Quando("^o usuário pesquisar sobre o modelo de carro \"(.*?)\"$", (String modelCar) -> {
            googleSearchPage.searchFor(modelCar);
        });

        Entao("^a página com os resultados da pesquisa terá o título \"(.*?)\"$", (String titlePage) -> {
            googleSearchPage.hasTitle(titlePage);
        });

        After((Scenario scenario) -> {
            if (!"passed".equals(scenario.getStatus())) {
                takeScreenshot(scenario);
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                driver.quit();
            }
        });
    }

    private void takeScreenshot(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }
}
