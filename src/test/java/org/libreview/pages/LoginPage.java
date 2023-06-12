package org.libreview.pages;

import org.libreview.base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver webDriver;

    public LoginPage() {
        webDriver = DriverFactory.getDriver();
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "loginForm-email-input")
    public WebElement username;
    @FindBy(id = "loginForm-password-input")
    public WebElement password;
    @FindBy(id = "loginForm-submit-button")
    public WebElement login;
    @FindBy(id = "login-title-text")
    public WebElement memberLoginTitle;

    public void submitLogin(String username, String password) {
        System.out.println("Performing action on element: " + login);
        waitForMemberLoginPage();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        login.click();
    }
    WebDriverWait wait;
    public void waitForMemberLoginPage() {
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(memberLoginTitle));
    }

}
