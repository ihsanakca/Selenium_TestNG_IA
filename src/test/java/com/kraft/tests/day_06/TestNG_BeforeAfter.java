package com.kraft.tests.day_06;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestNG_BeforeAfter {
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
    public void test1() {
        driver.navigate().to("https://www.krafttechexlab.com/login");
        WebElement form = driver.findElement(By.xpath("//form"));

        System.out.println(form.getAttribute("innerHTML"));

        System.out.println("--------------------");

        System.out.println(form.getAttribute("outerHTML"));

    }

    @Test
    public void test2() throws InterruptedException {
       driver.get("https://www.saucedemo.com/");
        List<WebElement> loginInputs = driver.findElements(By.xpath("//input"));
        loginInputs.get(0).sendKeys("standard_user");
        loginInputs.get(1).sendKeys("secret_sauce");
        loginInputs.get(2).click();
        Thread.sleep(3000);

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        for (WebElement product : products) {
            System.out.println(product.getText());
        }

        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getText());
        }

        for (int i = products.size() - 1; i >= 0; i--) {
            System.out.println(products.get(i).getText());
        }

        products.forEach(e->{
            System.out.println(e.getText());
        });

    }


}
