package com.kraft.tests.day_07;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectElements {
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

        driver.get("https://www.amazon.com/");
        WebElement searchDropdownBox = driver.findElement(By.id("searchDropdownBox"));

        Select select=new Select(searchDropdownBox);

        select.selectByVisibleText("Baby");
        System.out.println(select.getFirstSelectedOption().getText());


        Thread.sleep(2000);
        select.selectByIndex(5);
        Thread.sleep(2000);
        select.selectByValue("search-alias=hpc-intl-ship");
        Thread.sleep(2000);

        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
         //   System.out.println(option.getText());
        }

        options.get(5).getText();

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
       // WebElement element = driver.findElement(By.xpath("//div[text()='Select Option']"));
        driver.findElement(xPathLocator("Select Option")).click();

        //driver.findElement(By.xpath("//div[text()='Group 1, option 1']")).click();
        driver.findElement(xPathLocator("Group 1, option 1")).click();

        Thread.sleep(2000);
    }
    By xPathLocator(String text){
        return By.xpath("//*[text()='"+text+"']");
    }
}
