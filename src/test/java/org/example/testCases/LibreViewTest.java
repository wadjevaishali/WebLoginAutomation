package org.example.testCases;

import org.example.base.BaseTest;
import org.example.base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LibreViewTest extends BaseTest {

    @Test
    public void verifyLoginFunctionality() throws InterruptedException {
        WebDriver webDriver = DriverFactory.getDriver();
        webDriver.get("https://www.libreview.com/");

        Thread.sleep(3000);
    }
}
