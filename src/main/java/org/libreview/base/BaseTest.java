package org.libreview.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    WebDriver webDriver = null;
    Wait wait;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();

        webDriver.get("https://www.libreview.com/");
        DriverFactory.setWebDriver(webDriver);
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.getDriver().quit();
    }

}
