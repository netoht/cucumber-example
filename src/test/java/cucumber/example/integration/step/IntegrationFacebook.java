//package cucumber.example.integration.step;
//
//import java.util.*;
//import java.util.concurrent.*;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.support.ui.*;
//
//public class IntegrationFacebook extends WebBrowser {
//
//    private String popupWindow;
//    private final String UOL_PAGE_URL;
//    private final String UOL_PAGE_URL_FULL;
//    private final boolean isProducao = false;
//
//    public IntegrationFacebook() {
//        if (isProducao) {
//            UOL_PAGE_URL = "http://bt-pocs.uol.com.br";
//            UOL_PAGE_URL_FULL = "http://noticias.uol.com.br/internacional/ultimas-noticias/derspiegel/2014/09/18/o-rei-alex-o-homem-por-tras-do-movimento-pela-independencia-da-escocia.htm";
//
//        } else if (!isProducao) {
//            UOL_PAGE_URL = "http://noticias.uol.com.br";
//            UOL_PAGE_URL_FULL = UOL_PAGE_URL + "/barra-social/uol.html";
//        }
//    }
//
//    public void accessHomeFacebook() throws Exception {
//        loadPage("https://www.facebook.com/");
//    }
//
//    public void loginFacebook() throws Exception {
//        WebElement email = driver().findElement(By.id("email"));
//        WebElement pass = driver().findElement(By.id("pass"));
//        email.clear();
//        email.sendKeys("l-dev-berlim@uolinc.com");
//        pass.clear();
//        pass.sendKeys("mudar@123");
//        driver().findElement(By.id("loginbutton")).click();
//    }
//
//    public void logoutFacebook() throws Exception {
//        accessHomeFacebook();
//        driver().findElement(By.id("userNavigationLabel")).click();
//        driver().findElement(By.cssSelector("label.uiLinkButton:nth-child(4)")).click();
//    }
//
//    public void revokePermissionsAppFacebook() throws Exception {
//        loadPage(UOL_PAGE_URL + "/test/facebook-revoke-permissions.html");
//        TimeUnit.SECONDS.sleep(2);
//    }
//
//    public void authorizePermissionsAppFacebook(String group) throws Exception {
//        loadPage(UOL_PAGE_URL + "/test/facebook-authorize-permissions.html?group=" + group);
//
//        WebElement fbStatus = null;
//        try {
//            TimeUnit.SECONDS.sleep(2);
//            fbStatus = driver().findElement(By.id("FBStatus"));
//        } catch (NoSuchElementException ignored) {
//        }
//
//        if (fbStatus == null || (fbStatus.isDisplayed() && !fbStatus.getText().equals("connected"))) {
//            clickOnButtonAuthorizeAppFacebook();
//        }
//    }
//
//    public void setGroupInCookieBTCTL(FacebookGroup group) throws Exception {
//        loadPage(UOL_PAGE_URL + "/test/setCookieBTCTL.html?group=" + group.name());
//    }
//
//    public void accessPageUOL() throws Exception {
//        loadPage(UOL_PAGE_URL_FULL);
//    }
//
//    public void clickOnButtonFacebookShare() throws Exception {
//        driver().findElement(By.cssSelector(".pg-share-button.pg-share-facebook")).click();
//
//        new WebDriverWait(driver(), 10000).until(new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                return driver.getWindowHandles().size() > 1;
//            }
//        });
//
//        Iterator<String> windows = driver().getWindowHandles().iterator();
//        String mainWindow = windows.next();
//        popupWindow = windows.next();
//        driver().switchTo().window(popupWindow);
//    }
//
//    public void clickOnButtonAuthorizeAppFacebook() throws Exception {
//        driver().findElement(By.cssSelector("button[name='__CONFIRM__']")).click();
//    }
//
//    public void clickOnButtonCancelAppFacebook() throws Exception {
//        driver().findElement(By.cssSelector("button[name='__CANCEL__']")).click();
//    }
//
//    public void clickOnButtonPublishOnSharePageFacebook() throws Exception {
//        driver().findElement(By.cssSelector("textarea.uiTextareaAutogrow")).sendKeys(new Date().toString());
//        driver().findElement(By.cssSelector("input[name='publish']")).click();
//    }
//
//    public void clickOnButtonCancelOnSharePageFacebook() throws Exception {
//        driver().findElement(By.cssSelector("input[name='cancel']")).click();
//    }
//}
