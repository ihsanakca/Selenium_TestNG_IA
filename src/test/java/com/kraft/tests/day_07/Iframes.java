package com.kraft.tests.day_07;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Iframes {
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
        driver.get("https://testpages.herokuapp.com/styled/iframes-test.html");
        driver.switchTo().frame("thedynamichtml");
        System.out.println(driver.findElement(By.tagName("h1")).getText());

        driver.switchTo().parentFrame();

        WebElement frame2 = driver.findElement(By.xpath("//*[@src='frames/frames-header.html']"));
        driver.switchTo().frame(frame2);
        System.out.println(driver.findElement(By.tagName("h1")).getText());

    }

    @Test
    public void test2() {
        driver.get("https://testpages.herokuapp.com/styled/iframes-test.html");
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.tagName("h1")).getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("h1")).getText());

    }

    @Test
    public void nestedFrames() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/frames/frames-test.html");
        Thread.sleep(2000);


        driver.switchTo().frame("top");
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame("left");
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        driver.switchTo().defaultContent();

        WebElement rightFrame = driver.findElement(By.xpath("//frame[@src='get-list?name=Right&list=50']"));
        driver.switchTo().frame(rightFrame);
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        driver.switchTo().defaultContent();


        driver.switchTo().frame(4);
        WebElement element = driver.findElement(By.xpath("//a[text()='EvilTester.com']"));
        System.out.println(element.getText());


    }
}
