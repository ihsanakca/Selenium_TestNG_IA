package com.kraft.tests.day_15;

import com.kraft.pages.DashboardPage;
import com.kraft.pages.LoginPage;
import com.kraft.tests.TestBase;
import com.kraft.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDF_LoginTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    @DataProvider
    public Object[][] userData(){
        ExcelUtil qaTeam1 = new ExcelUtil("src/test/resources/LoginList.xlsx", "QaTeam1");
        String[][] data = qaTeam1.getDataArrayWithoutFirstRow();
        return data;
    }

    @Test(dataProvider = "userData")
    public void loginTestWithDDF(String  yourName, String yourEmail, String password){
        extentLogger=report.createTest("TC_0005 DDF Login Test");

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();

        extentLogger.info("navigate to Login page");
        extentLogger.info("login with valid credentials");
        loginPage.loginWithCredentialsMtd(yourEmail,password);

        extentLogger.info("verify that dashboard page is opened");
        String actualName = dashboardPage.userName.getText();
        Assert.assertEquals(actualName,yourName);

        extentLogger.pass("Passed");


    }

    @Test(dataProvider = "userData")
    public void loginTestWithDDF2(String  yourName, String yourEmail, String password){
        extentLogger=report.createTest("TC_0005 DDF Login Test");

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();

        extentLogger.info("navigate to Login page");
        extentLogger.info("login with valid credentials");
        loginPage.loginWithCredentialsMtd(yourEmail,password);

        extentLogger.info("verify that dashboard page is opened");
        String actualName = dashboardPage.userName.getText();
        Assert.assertEquals(actualName,yourName);

        dashboardPage.logoutAndNavigateToLoginPage(yourName);

        extentLogger.pass("Passed");


    }

}
