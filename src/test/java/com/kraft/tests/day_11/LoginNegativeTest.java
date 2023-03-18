package com.kraft.tests.day_11;

import com.kraft.pages.LoginPage;
import com.kraft.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginNegativeTest extends TestBase {
    LoginPage loginPage;
    @Test
    public void wrongEmailTest(){
       loginPage=new LoginPage();
       loginPage.emailInputBox.sendKeys("blabla");
       loginPage.passwordInputBox.sendKeys("12345678");
       loginPage.loginBtn.click();

        Assert.assertTrue(loginPage.warningEmailMessage.getText().contains("Email address is incorrect. Please check"));
    }

    @Test
    public void wrongPasswordTest(){
        loginPage=new LoginPage();
        loginPage.loginWithCredentialsMtd("sgezer@gmail.com","251çççö");
        Assert.assertTrue(loginPage.warningPasswordMessage.getText().contains("Password is incorrect. Please check"));
    }
}
