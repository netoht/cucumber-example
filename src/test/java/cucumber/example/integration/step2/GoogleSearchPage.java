package cucumber.example.integration.step2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage {

    private String url = "http://www.google.com";
    private WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(id = "resultStats")
    private WebElement resultStats;

    public void searchFor(String text) {
        searchBox.clear();
        searchBox.sendKeys(text);
        searchBox.submit();
    }

    public void visit() {
        driver.get(url);
    }

    public void hasTitle(String titlePageExpected) {
        assertTrue(resultStats.isDisplayed());
        assertEquals(titlePageExpected, driver.getTitle());
    }
}
