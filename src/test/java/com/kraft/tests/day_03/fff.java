package com.kraft.tests.day_03;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class fff {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("http://ourvirtualmarket.com/");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@class='popup-close']")).click();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Login")).click();
        WebElement email = driver.findElement(By.id("email"));
        Thread.sleep(2000);
        email.sendKeys("fdgfdgfdgd");
        Thread.sleep(2000);
        driver.findElement(By.id("send2")).click();

        System.out.println("email.getAttribute(\"validationMessage\") = " + email.getAttribute("validationMessage"));

        driver.quit();
    }
}
