package org.example.base;

import dev.failsafe.internal.util.Durations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    WebDriver webDriver = null;
    Wait wait;

    @BeforeClass
    public void setup() {
        String browser = System.getProperty("browser", "chrome");

        if(browser.contains("chrome")) {
                webDriver = new ChromeDriver();
        } else if (browser.contains("firefox")) {
            webDriver = new FirefoxDriver();
        }

        DriverFactory.setWebDriver(webDriver);
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.getDriver().quit();
    }

}
