package org.libreview.pages;

import org.libreview.base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserPreferencePage {
    WebDriver webDriver;
    public UserPreferencePage() {
        webDriver = DriverFactory.getDriver();
        PageFactory.initElements(webDriver, this);
    }

    //close Abbott consent window
    @FindBy(id = "truste-consent-close")
    public WebElement consentClose;
    @FindBy(id = "country-select")
    public WebElement countrySelect;
    @FindBy(id = "language-select")
    public WebElement languageSelect;
    @FindBy(id = "submit-button")
    public WebElement preferenceSubmit;

    WebDriverWait wait;
    public void closeConsent() {
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(countrySelect));
        consentClose.click();
    }
    public void submitPreference(String preferredCountry, String preferredLanguage) {
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(countrySelect));
        new Select(countrySelect).selectByVisibleText(preferredCountry);
        new Select(languageSelect).selectByVisibleText(preferredLanguage);
        preferenceSubmit.click();
    }
}
