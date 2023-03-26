package com.kraft.tests.day_13;

import com.kraft.pages.AddEducationPage;
import com.kraft.pages.DashboardPage;
import com.kraft.pages.LoginPage;
import com.kraft.pages.OverviewPage;
import com.kraft.tests.TestBase;
import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddEducation_2 extends TestBase {
    /**
     1-open chrome browser
     2-navigate to https://www.krafttechexlab.com/login by using configuration.properties
     3-login with parameterized login method
     4-Assert successful login with user name
     5-Navigate to My Profile with related method
     6-Verify that overview page is displayed
     7-Navigate to Add Education tab with related method
     8-Verify that add education page is displayed
     9-Fill the form with parameterized login method (using actions class is optional)
     10-Verify that added education information can be seen at overview page...

     11-Delete last added education

     important note: every student should use own credentials, otherwise the test case will fail....
     */
    LoginPage loginPage;
    DashboardPage dashboardPage;
    OverviewPage overviewPage;
    AddEducationPage addEducationPage;
    @Test
    public void addEducation2(){

        extentLogger= report.createTest("TC_003 Addind/Deleting Education");

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        overviewPage=new OverviewPage();
        addEducationPage=new AddEducationPage();

        extentLogger.info("enter the site with valid credentials");
        loginPage.loginWithCredentialsMtd(ConfigurationReader.get("userEmail"),ConfigurationReader.get("password"));

        extentLogger.info("verify using name");
        String actualUserName = dashboardPage.userName.getText();
        String expectedName=ConfigurationReader.get("userName");
        Assert.assertEquals(actualUserName,expectedName);

        extentLogger.info("navigate to my profile");
        dashboardPage.navigateTabAndModule(ConfigurationReader.get("userName"),"My Profile");

        extentLogger.info("verify overview page is displayed");
        BrowserUtils.waitForVisibility(overviewPage.overviewPageSubTitle,5);
        Assert.assertTrue(overviewPage.overviewPageSubTitle.isDisplayed());

        extentLogger.info("navigate to add education");
        overviewPage.navigateUserProfileTabs("Add Education");

        extentLogger.info("verify add education page is displayed");
        BrowserUtils.waitForVisibility(addEducationPage.addEducationBtn,5);
        Assert.assertTrue(addEducationPage.addEducationBtn.isDisplayed());

        extentLogger.info("new education record added");
        addEducationPage.addEducation("Gazi","good","finance","11122020","11112021","good education");

        extentLogger.info("verify education record is added");
        String actualText = overviewPage.addedEducationName("Gazi");
        String expectedText="Gazi";
        Assert.assertEquals(actualText,expectedText);

        extentLogger.info("last added record is deleted");
        overviewPage.deleteEducation("Gazi");

        extentLogger.pass("Pass...!");


    }
}
