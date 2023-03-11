package com.kraft.tests.day_07;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Alerts {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

        driver.findElement(By.id("alertexamples")).click();
        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);

        driver.findElement(By.id("confirmexample")).click();
        alert.dismiss();
        Thread.sleep(2000);

        driver.findElement(By.id("promptexample")).click();
        alert.sendKeys("Ahmet");
        Thread.sleep(2000);
        System.out.println(alert.getText());

    }
}
