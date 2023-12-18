package com.kraft.tests.day_03;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathPractise {

    public static void main(String[] args) throws InterruptedException {
/**
 * navigate to https://demowebshop.tricentis.com/desktops
 * click on Simple Computer Add to cart button by using item name in the locator
 * close driver
 */


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://demowebshop.tricentis.com/desktops");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        WebElement addtoCart = driver.findElement(By.xpath("//a[text()='Simple Computer']/ancestor::div[@class='details']//input"));
        addtoCart.click();

        Thread.sleep(5000);

        driver.quit();

    }

}
