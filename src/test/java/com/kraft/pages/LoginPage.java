package com.kraft.pages;

import com.kraft.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(id = "yourPassword")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginBtn;

    @FindBy(xpath = "//div[contains(text(),'Email address is incorrect. Please check')]")
    public WebElement warningEmailMessage;

    @FindBy(xpath = "//*[contains(text(),'Password is incorrect. Please check')]")
    public WebElement warningPasswordMessage;

    public void loginMtd(){
        String userEmail= ConfigurationReader.get("userEmail");
        String password=ConfigurationReader.get("password");

        emailInputBox.sendKeys(userEmail);
        passwordInputBox.sendKeys(password);
        loginBtn.click();
    }

    public void loginWithCredentialsMtd(String userEmail,String password){
        emailInputBox.sendKeys(userEmail);
        passwordInputBox.sendKeys(password);
        loginBtn.click();
    }
}
