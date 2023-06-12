package org.libreview.testCases;

import org.libreview.UserConfig;
import org.libreview.base.BaseTest;
import org.libreview.base.DriverFactory;
import org.libreview.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class LibreViewTest extends BaseTest {

    @Test
    public void verifyLoginFunctionality() throws InterruptedException, IOException {
        WebDriver webDriver = DriverFactory.getDriver();
        webDriver.manage().window().maximize();
        //TODO: Wait for the site to load instead

        //close Abbott consent window
        UserPreferencePage userPreferencePage = new UserPreferencePage();
        userPreferencePage.closeConsent();

        // select country and language preference, and then submit
        userPreferencePage.submitPreference(UserConfig.libreviewCountry, UserConfig.libreviewLanguage);

        //Login with credentials
        LoginPage loginPage = new LoginPage();
        loginPage.submitLogin(UserConfig.libreviewUsername,UserConfig.libreviewPassword);

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
        outlookPage.submitUsername(UserConfig.libreviewUsername);
        outlookPage.submitPassword(UserConfig.outlookPassword);
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
