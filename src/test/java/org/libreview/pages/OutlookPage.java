package org.libreview.pages;

import org.libreview.base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OutlookPage {
    WebDriver webDriver;

    public OutlookPage() {
        webDriver = DriverFactory.getDriver();
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//nav[@aria-label='Quick links']//a[@class='internal sign-in-link'][normalize-space()='Sign in']")
    public WebElement signIn;

    @FindBy(id = "i0116")
    public WebElement username;

    @FindBy(id = "i0118")
    public WebElement password;

    @FindBy(id = "idSIButton9")
    public WebElement submit;

    @FindBy(id = "idBtn_Back")
    public WebElement noSignedIn;

    @FindBy(xpath = "//div[contains(@class, 'hcptT')]")
    public WebElement emails;


    @FindBy(xpath = "//table[@class='x_main']//tr/td[contains(text(), 'Your security code')]")
    public WebElement verificationCode;

    WebDriverWait wait;
    public void clickSignIn() {
        System.out.println("Performing action on element: " + signIn);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(signIn));
        signIn.click();
    }

    public void submitUsername(String username) {
        System.out.println("Performing action on element: " + submit);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(this.username));
        this.username.sendKeys(username);
        submit.click();
    }

    public void submitPassword(String password) {
        System.out.println("Performing action on element: " + submit);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(this.password));
        this.password.sendKeys(password);
        submit.click();
    }

    public void clickStaySignedNo(){
        System.out.println("Performing action on element: " + noSignedIn);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(noSignedIn));
        noSignedIn.click();
    }

    public String fetchVerificationCode(){
        System.out.println("Performing action on element: " + emails);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(this.emails));
        //By default the emails will return the first element from the list
        emails.click();

        wait.until(ExpectedConditions.visibilityOf(verificationCode));
        String verificationCodeString = verificationCode.getText();

        if (verificationCodeString.contains(":"))
            return verificationCodeString.split(":")[1];
        return "";
    }

    public void switchToTwoFactorAuthPage(String originalWindow){
        webDriver.switchTo().window(originalWindow);
    }
}


