package com.kraft.tests.day_2;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CallWDF {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/login");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        WebElement email = driver.findElement(By.id("email"));

        //email.sendKeys("ahmet");

        WebElement loginBtn=driver.findElement(By.tagName("button"));
        String loginBtnText = loginBtn.getText();
        System.out.println("loginBtnText = " + loginBtnText);

        WebElement password=driver.findElement(By.id("yourPassword"));

        email.sendKeys("sgezer@gmail.com");
        password.sendKeys("12345678");
        loginBtn.click();

        driver.quit();


    }
}
