package com.kraft.tests.day_11;

import com.kraft.pages.LocatorsLoginPage;
import com.kraft.tests.TestBase;
import com.kraft.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class LoginTestWithInterfaceLocators extends TestBase implements LocatorsLoginPage {

    @Test
    public void loginTest(){

        driver.findElement(LocatorsLoginPage.emailBox_loc).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(LocatorsLoginPage.passwordBox_loc).sendKeys(ConfigurationReader.get("password"));
        driver.findElement(LocatorsLoginPage.loginBtn_loc).click();
    }
}
