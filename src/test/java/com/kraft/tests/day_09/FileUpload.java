package com.kraft.tests.day_09;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void fileUpload() throws InterruptedException {
        driver.get("https://demoqa.com/upload-download");
        WebElement uploadFile = driver.findElement(By.id("uploadFile"));
        Thread.sleep(2000);
        uploadFile.sendKeys("C:\\Users\\HP\\Desktop\\ccc.txt");

    }

    @Test
    public void fileUpload2() throws InterruptedException {
        driver.get("https://demoqa.com/upload-download");
        WebElement uploadFile = driver.findElement(By.id("uploadFile"));

        String projectPath=System.getProperty("user.dir");
        String filePath="src/test/resources/ccc.txt";
        String fullPath=projectPath+"/"+filePath;

        uploadFile.sendKeys(fullPath);

    }
}
