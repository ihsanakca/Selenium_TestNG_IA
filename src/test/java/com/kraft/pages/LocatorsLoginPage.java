package com.kraft.pages;

import org.openqa.selenium.By;

public interface LocatorsLoginPage {

    By emailBox_loc=By.id("email");
    By passwordBox_loc=By.id("yourPassword");
    By loginBtn_loc=By.xpath("//*[text()='Login']");
}
