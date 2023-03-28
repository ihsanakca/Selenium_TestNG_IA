package com.kraft.tests.day_15;

import com.kraft.pages.AddEducationPage;
import com.kraft.pages.DashboardPage;
import com.kraft.pages.LoginPage;
import com.kraft.pages.OverviewPage;
import com.kraft.tests.TestBase;
import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDF_AddEducationTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    OverviewPage overviewPage;
    AddEducationPage addEducationPage;

    @DataProvider
    public Object[][] education(){

        ExcelUtil qaTeam3 = new ExcelUtil("src/test/resources/LoginList.xlsx", "QaTeam3");
        String[][] educationData = qaTeam3.getDataArrayWithoutFirstRow();
        return educationData;
    }



    @Test(dataProvider ="education" )
    public void addEducation2(String userEmail,String password,String userName,String school,String degree,String study,String fromDate,
    String toDate,String programDescription){

        extentLogger= report.createTest("TC_007 Addind/Deleting Education");

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        overviewPage=new OverviewPage();
        addEducationPage=new AddEducationPage();

        extentLogger.info("enter the site with valid credentials");
        loginPage.loginWithCredentialsMtd(userEmail,password);

        extentLogger.info("verify using name");
        String actualUserName = dashboardPage.userName.getText();
        String expectedName=userName;
        Assert.assertEquals(actualUserName,expectedName);

        extentLogger.info("navigate to my profile");
        dashboardPage.navigateTabAndModule(userName,"My Profile");

        extentLogger.info("verify overview page is displayed");
        BrowserUtils.waitForVisibility(overviewPage.overviewPageSubTitle,5);
        Assert.assertTrue(overviewPage.overviewPageSubTitle.isDisplayed());

        extentLogger.info("navigate to add education");
        overviewPage.navigateUserProfileTabs("Add Education");

        extentLogger.info("verify add education page is displayed");
        BrowserUtils.waitForVisibility(addEducationPage.addEducationBtn,5);
        Assert.assertTrue(addEducationPage.addEducationBtn.isDisplayed());

        extentLogger.info("new education record added");
        addEducationPage.addEducation(school,degree,study,fromDate,toDate,programDescription);

        extentLogger.info("verify education record is added");
        String actualText = overviewPage.addedEducationName(school);
        String expectedText=school;
        Assert.assertEquals(actualText,expectedText);

        extentLogger.info("last added record is deleted");
        overviewPage.deleteEducation(school);

        extentLogger.pass("Pass...!");


    }
}
