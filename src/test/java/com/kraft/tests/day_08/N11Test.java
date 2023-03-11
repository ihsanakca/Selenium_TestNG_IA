package com.kraft.tests.day_08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class N11Test {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.n11.com/");

    }

    @AfterMethod
    public void dearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.id("myLocation-close-info")).click();
        driver.findElement(By.xpath("(//button[text()='Evet'])[1]")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='container']/li"));
        Actions actions = new Actions(driver);

        for (int i = 1; i <= elements.size(); i++) {
            actions.moveToElement(elements.get(i - 1)).perform();
            List<WebElement> elements2 = driver.findElements(By.xpath("//ul[@class='container']/li[" + i + "]//li"));
            for (int j = 1; j <= elements2.size(); j++) {
                WebElement altElementler = driver.findElement(By.xpath("(//ul[@class='container']/li[" + i + "]//li/a/span)[" + j + "]"));
                System.out.println(i + "/" + j + "- " + altElementler.getText());
                Thread.sleep(2000);
            }
            Thread.sleep(2000);
        }


    }
}
