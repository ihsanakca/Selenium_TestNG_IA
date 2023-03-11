package com.kraft.tests.day_07;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
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
        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");

        driver.findElement(By.linkText("Basic Ajax in new page")).click();
//        driver.findElement(By.linkText("Attributes in new page")).click();
//        driver.findElement(By.linkText("Alerts In A New Window From JavaScript")).click();

        String currenTab = driver.getWindowHandle();

        Set<String> tabs = driver.getWindowHandles();

        for (String tab : tabs) {
            if (!currenTab.equals(tab)) {
                driver.switchTo().window(tab);
            }
        }
        System.out.println(driver.getCurrentUrl());

    }

    @Test
    public void test2() {
        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");

        driver.findElement(By.linkText("Basic Ajax in new page")).click();
        driver.findElement(By.linkText("Attributes in new page")).click();
        driver.findElement(By.linkText("Alerts In A New Window From JavaScript")).click();

        String currenTab = driver.getWindowHandle();

        Set<String> tabs = driver.getWindowHandles();

        String expectedTitle = "Test Page For Element Attributes";

        for (String tab : tabs) {
            driver.switchTo().window(tab);
            if (driver.getTitle().equals(expectedTitle)) {
                break;
            }
        }
        System.out.println(driver.getCurrentUrl());
    }
}
