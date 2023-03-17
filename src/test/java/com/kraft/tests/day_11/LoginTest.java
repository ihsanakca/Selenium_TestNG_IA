package com.kraft.tests.day_11;

import com.kraft.pages.DashboardPage;
import com.kraft.pages.LoginPage;
import com.kraft.tests.TestBase;
import com.kraft.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void loginTestWithConfigReader() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();

        loginPage.loginWithCredentialsMtd(ConfigurationReader.get("userEmail"), ConfigurationReader.get("password"));

        String actual = dashboardPage.dashboardPageSubTitle.getText();
        String expected = "Dashboard";

        Assert.assertEquals(actual, expected, "should be same");
    }

    @Test
    public void loginTestWithWebElements() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();

        loginPage.emailInputBox.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        loginPage.loginBtn.click();

        String actualName = dashboardPage.userName.getText();
        String expectedName = ConfigurationReader.get("userName");

        Assert.assertEquals(actualName, expectedName, "FAIL");
    }

    @Test
    public void loginTestWithoutParameter() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();

        loginPage.loginMtd();

        String actualJob = dashboardPage.userJob.getText();
        String expectedJob = ConfigurationReader.get("userJob");

        Assert.assertEquals(actualJob, expectedJob);


    }
}