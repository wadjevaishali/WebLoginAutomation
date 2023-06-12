package org.libreview.pages;

import org.libreview.base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    WebDriver webDriver;

    public HomePage() {
        webDriver = DriverFactory.getDriver();
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "main-header-meter-nav-link")
    public WebElement uploadDeviceNav;

    @FindBy(id = "meterUpload-linkedUpload-pat-button")
    public WebElement pressToBeginUpload;

    WebDriverWait wait;

    public void verifyPressToBeginUpload() {
        System.out.println("Performing click action on element: " + uploadDeviceNav);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(uploadDeviceNav));
        uploadDeviceNav.click();
        wait.until(ExpectedConditions.visibilityOf(pressToBeginUpload));
        Assert.assertTrue(pressToBeginUpload.isDisplayed());
    }
}
