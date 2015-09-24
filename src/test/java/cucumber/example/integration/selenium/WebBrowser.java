package cucumber.example.integration.selenium;

import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebBrowser {

    private FirefoxDriver driver;
    private final FirefoxProfile profile = new FirefoxProfile();

    public WebDriver driver() {
        return driver;
    }

    public FirefoxProfile profile() {
        return profile;
    }

    public void start() {
        start(10);
    }

    public void start(int waitForElementsInSeconds) {
        profile.setAcceptUntrustedCertificates(true);
        driver = new FirefoxDriver(profile);

        if (waitForElementsInSeconds > 0) {
            driver().manage().timeouts().implicitlyWait(waitForElementsInSeconds, TimeUnit.SECONDS);
        }
    }

    public void stop() {
        if (driver != null && CollectionUtils.isNotEmpty(driver.getWindowHandles())) {
            for (String windowId : driver.getWindowHandles()) {
                driver.switchTo().window(windowId).close();
            }
        }
    }

    public void waitForPopupClose(final int windowCount, int timeoutInSeconds) {
        new WebDriverWait(driver, timeoutInSeconds).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.getWindowHandles().size() < windowCount;
            }
        });
    }
}