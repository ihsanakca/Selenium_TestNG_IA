package com.kraft.tests.day_08;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StaleElement {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
     //  driver= Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
       // Driver.closeDriver();
    }



    @Test
    public void staleElement() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");
        WebElement ajaxElement = driver.findElement(By.linkText("Basic Ajax in new page"));
        System.out.println("ajaxElement.getText() = " + ajaxElement.getText());
        driver.navigate().refresh();
        Thread.sleep(2000);
        WebElement ajaxElement2 = driver.findElement(By.linkText("Basic Ajax in new page"));
        System.out.println("ajaxElement2.getText() = " + ajaxElement2.getText());
    }

    @Test
    public void staleElement2() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
        WebElement keyboards = driver.findElement(By.xpath("//span[text()='Keyboards']"));
        System.out.println("keyboards.getText() = " + keyboards.getText());
        keyboards.click();
        driver.navigate().back();
        Thread.sleep(2000);
        WebElement keyboards2 = driver.findElement(By.xpath("//span[text()='Keyboards']"));
        System.out.println("keyboards.getText() = " + keyboards2.getText());
    }

    @Test
    public void implicitlyWait() {
        driver.get("https://www.hepsiburada.com/ara?q=laptop");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        JavascriptExecutor js= (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,500)");

        WebElement laptop = driver.findElement(By.xpath("//h3[text()=' Abra A5 V17.2.3 Intel Core i5-11400H 16GB " +
                "RAM 500GB SSD 4GB RTX3050Ti FreeDOS 15.6\" FHD 144Hz Oyun Bilgisayarı']"));

        Actions actions=new Actions(driver);
        actions.moveToElement(laptop).perform();

        WebElement sepeteEkle = driver.findElement(By.xpath("(//button[@kind='primary'])[2]"));
        sepeteEkle.click();

    }

    @Test
    public void explicitlyWait() throws InterruptedException {
    driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
       // Thread.sleep(2000);

        WebDriverWait wait=new WebDriverWait(driver,10);

        WebElement strBtn=driver.findElement(By.id("button00"));
        wait.until(ExpectedConditions.visibilityOf(strBtn));

        List<WebElement> buttons = driver.findElements(By.xpath("//button"));
        WebElement element1 = buttons.get(0);
        WebElement element2 = buttons.get(1);
        WebElement element3 = buttons.get(2);
        WebElement element4 = buttons.get(3);

        element1.click();
        wait.until(ExpectedConditions.elementToBeClickable(element2));
        element2.click();

        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(2)));
        element3.click();

        wait.until(ExpectedConditions.elementToBeClickable(element4));
        element4.click();


//        WebElement strBtn=driver.findElement(By.id("button00"));
//        strBtn.click();
//
//        WebElement firstBtn=driver.findElement(By.id("button01"));
//        wait.until(ExpectedConditions.elementToBeClickable(firstBtn));
//        firstBtn.click();
//
//        WebElement secondBtn=driver.findElement(By.id("button02"));
//        wait.until(ExpectedConditions.elementToBeClickable(secondBtn));
//        secondBtn.click();
//
//        WebElement thirdBtn=driver.findElement(By.id("button03"));
//        wait.until(ExpectedConditions.elementToBeClickable(thirdBtn));
//        thirdBtn.click();
    }
}
