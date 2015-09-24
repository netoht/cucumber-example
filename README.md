# cucumber-example - Java

Run the app:

	mvn spring-boot:run

Run the tests:

	mvn clean compile test

### Troubleshoot (Selenium)

**1\. Cannot find firefox binary in PATH**

```
org.openqa.selenium.WebDriverException: Cannot find firefox binary in PATH. Make sure firefox is installed. OS appears to be: VISTA
Build info: version: '2.20.0', revision: '16008', time: '2012-02-27 19:03:59'
System info: os.name: 'Windows 7', os.arch: 'x86', os.version: '6.1', java.version: '1.6.0_26'
Driver info: driver.version: FirefoxDriver
    at org.openqa.selenium.firefox.internal.Executable.<init>(Executable.java:52)
    at org.openqa.selenium.firefox.FirefoxBinary.<init>(FirefoxBinary.java:56)
    at org.openqa.selenium.firefox.FirefoxBinary.<init>(FirefoxBinary.java:52)
    at org.openqa.selenium.firefox.FirefoxDriver.<init>(FirefoxDriver.java:88)
    at FirstTest.setUp(FirstTest.java:16)
```

**R)** VM arguments: `-Dwebdriver.firefox.bin=c:/opt/aplicativos/Firefox/firefox.exe`



##### References:

- [Cucumber](https://cucumber.io/)
- [Cucumber Docs](https://cucumber.io/docs)
- [Cucumber JVM](https://cucumber.io/docs/reference/jvm)
- [Reports](https://cucumber.io/docs/reference#reports)
- [Page Objects Pattern](https://code.google.com/p/selenium/wiki/PageObjects)
- [PageFactory](https://code.google.com/p/selenium/wiki/PageFactory)
- [Browser automation with Selenium](https://cucumber.io/docs/reference/browser-automation#selenium)
- [Selenium WebDriver](http://docs.seleniumhq.org/docs/03_webdriver.jsp#introducing-the-selenium-webdriver-api-by-example)
- Selenium Take Screenshots [Link1](https://techblog.polteq.com/en/take-screenshots/) [Link2](https://cucumber.io/docs/reference#after)
- [WebDriver: Explicit and Implicit Waits](http://www.seleniumhq.org/docs/04_webdriver_advanced.jsp)