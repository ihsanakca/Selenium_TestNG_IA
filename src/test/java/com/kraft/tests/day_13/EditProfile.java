package com.kraft.tests.day_13;

import com.kraft.pages.*;
import com.kraft.tests.TestBase;
import com.kraft.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditProfile extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    OverviewPage overviewPage;
    AddExperiencePage addExperiencePage;
    AddEducationPage addEducationPage;

    @Test
    public void addExperienceTest() {
        extentLogger= report.createTest("TC0001_Adding new experience");

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        overviewPage=new OverviewPage();
        addExperiencePage=new AddExperiencePage();

        extentLogger.info("Navigate to "+ ConfigurationReader.get("url"));
        extentLogger.info("Enter site with valid credentials");
        loginPage.loginMtd();

        extentLogger.info("verify that login is successful with account name= "+ConfigurationReader.get("userName"));
        String actualUserName = dashboardPage.userName.getText();
        String expectedUserName=ConfigurationReader.get("userName");
        Assert.assertEquals(actualUserName,expectedUserName);

        extentLogger.info("click to my profile button");
        dashboardPage.navigateTabAndModule(ConfigurationReader.get("userName"),"My Profile");

        extentLogger.info("navigate to experience tab");
        overviewPage.navigateUserProfileTabs("Add Experience");

        extentLogger.info("adding new experience");
        addExperiencePage.addExperienceMtd();


        extentLogger.pass("PASSED");


    }

    @Test
    public void addEducationTest() {
        extentLogger= report.createTest("TC0002_Adding new education");

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        overviewPage=new OverviewPage();
        addEducationPage=new AddEducationPage();


        extentLogger.info("Navigate to "+ ConfigurationReader.get("url"));
        extentLogger.info("Enter site with valid credentials");
        loginPage.loginMtd();

        extentLogger.info("verify that login is successful with account name= "+ConfigurationReader.get("userName"));
        String actualUserName = dashboardPage.userName.getText();
        String expectedUserName=ConfigurationReader.get("userName");
        Assert.assertEquals(actualUserName,expectedUserName);

        extentLogger.info("click to my profile button");
        dashboardPage.navigateTabAndModule(ConfigurationReader.get("userName"),"My Profile");

        extentLogger.info("navigate to education tab");
        overviewPage.navigateUserProfileTabs("Add Education");

        extentLogger.info("adding new education");
        addEducationPage.addEducation("Kraft","Master","SDET","11122020","12122022","SDET Course");

        extentLogger.pass("PASSED");

    }
}
