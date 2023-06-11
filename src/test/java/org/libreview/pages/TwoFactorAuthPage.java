package org.libreview.pages;

import org.libreview.base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TwoFactorAuthPage {

    WebDriver webDriver;

    public TwoFactorAuthPage() {
        webDriver = DriverFactory.getDriver();
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "twoFactor-step1-next-button")
    public WebElement sendCode;

    @FindBy(id = "twoFactor-step2-next-button")
    public WebElement nextStep;

    @FindBy(id = "twoFactor-step2-code-input")
    public WebElement codeInput;

    @FindBy(id = "twoFactor-step2-next-button")
    public WebElement codeSubmit;

    public void sendAuthCode() {
        waitForTwoFactorAuthPage();
        sendCode.click();
    }

    public void openOutlook() {
        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.get("https://outlook.com/");
    }

    public void enterAndSubmitCode(String verificationCode){
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(codeInput));
        codeInput.sendKeys(verificationCode.trim());
        codeSubmit.click();
    }
    WebDriverWait wait;
    public void waitForTwoFactorAuthPage() {
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(sendCode));
    }

    public void verfiyNextStepButtonDisabled() {
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.invisibilityOf(sendCode));
        Assert.assertFalse(nextStep.isEnabled());
    }

}
