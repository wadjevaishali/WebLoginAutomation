package org.libreview.testCases;

import org.libreview.base.BaseTest;
import org.libreview.base.DriverFactory;
import org.libreview.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LibreViewTest extends BaseTest {

    @Test
    public void verifyLoginFunctionality() throws InterruptedException {
        WebDriver webDriver = DriverFactory.getDriver();
        webDriver.manage().window().maximize();
        //TODO: Wait for the site to load instead

        //close Abbott consent window
        UserPreferencePage userPreferencePage = new UserPreferencePage();
        userPreferencePage.closeConsent();

        // select country and language preference, and then submit
        userPreferencePage.submitPreference("United States", "English");

        //Login with credentials
        LoginPage loginPage = new LoginPage();
        loginPage.submitLogin("codechallengeadc@outlook.com","P@ssword$12");

        //On 2FA page, click button Send Code
        String originalWindow = webDriver.getWindowHandle();
        TwoFactorAuthPage twoFactorAuthPage = new TwoFactorAuthPage();
        twoFactorAuthPage.sendAuthCode();
        twoFactorAuthPage.verfiyNextStepButtonDisabled();

        //open outlook
        twoFactorAuthPage.openOutlook();

        //Login outlook
        OutlookPage outlookPage = new OutlookPage();
        outlookPage.clickSignIn();

        // Enter username and password, and sign in
        outlookPage.submitUsername("codechallengeadc@outlook.com");
        outlookPage.submitPassword("P@ssword$1234");
        outlookPage.clickStaySignedNo();

        // Fetch verification code
        String verificationCode = outlookPage.fetchVerificationCode();

        // Switch to original window
        outlookPage.switchToTwoFactorAuthPage(originalWindow);

        // Enter verification code and continue
        twoFactorAuthPage.enterAndSubmitCode(verificationCode);

        //Verify Press to Begin upload
        HomePage homePage = new HomePage();
        homePage.verifyPressToBeginUpload();
    }
}
