package com.kraft.tests.day_08;

import com.github.javafaker.Faker;
import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionClass {
    WebDriver driver;
    Actions actions;
    Faker faker = new Faker();

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void doubleClick() {
        driver.get("https://skill-test.net/mouse-double-click");
        WebElement clicker = driver.findElement(By.id("clicker"));
        actions.doubleClick(clicker).perform();


    }

    @Test
    public void actionsForm() {
        driver.get("https://www.krafttechexlab.com/forms/elements");
        WebElement firstElement = driver.findElement(By.xpath("//input[@name='text']"));
        actions.click(firstElement)
                .sendKeys("Ahmet Ay" + Keys.TAB)
                .sendKeys("Ahmetay@aaa.com")
                .sendKeys(Keys.TAB)
                .sendKeys("1234566788" + Keys.TAB)
                .sendKeys("155" + Keys.TAB + Keys.TAB)
                .sendKeys("01022022" + Keys.TAB)
                .sendKeys("1212P" + Keys.TAB + Keys.TAB)
                .sendKeys("AAAAAAA" + Keys.TAB + Keys.TAB + Keys.TAB + Keys.TAB + Keys.TAB + Keys.TAB + Keys.TAB + Keys.TAB + Keys.TAB)
                .sendKeys("aaaaa@ddd.com" + Keys.TAB)
                .sendKeys("12345678" + Keys.TAB)
                .sendKeys("No comment" + Keys.TAB + Keys.TAB + Keys.ENTER).perform();

    }

    @Test
    public void jsTest() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/forms/elements");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);

        WebElement customRange = driver.findElement(By.id("customRange1"));
        actions.dragAndDropBy(customRange, 500, 0).perform();
        Thread.sleep(3000);

        WebElement disabledRange = driver.findElement(By.id("disabledRange"));
        js.executeScript("arguments[0].setAttribute('min', '5')", disabledRange);
        Thread.sleep(3000);

        WebElement number = driver.findElement(By.xpath("//label[text()='Number']"));
        js.executeScript("arguments[0].scrollIntoView();", number);

        WebElement exampleColorInput = driver.findElement(By.id("exampleColorInput"));
        js.executeScript("arguments[0].setAttribute('value', '#FF0000')", exampleColorInput);

        WebElement submit = driver.findElement(By.xpath("//button[@name='submit']"));
        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView();", submit);
        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView();", number);
        Thread.sleep(3000);

        js.executeScript("arguments[0].scrollIntoView(true);"
                + "arguments[0].click()", submit);

        Thread.sleep(3000);

        System.out.println("title= " + js.executeScript("return document.title;").toString());
        System.out.println("url= " + js.executeScript("return document.URL;").toString());

    }

    @Test
    public void actionFillForm() {
        driver.get("http://ourvirtualmarket.com/");
        driver.findElement(By.xpath("//button[@class='popup-close']")).click();
        driver.findElement(By.xpath("(//a[text()='Register'])[2]")).click();

        WebElement firstname = driver.findElement(By.id("input-firstname"));

        actions.click(firstname)
                .sendKeys(faker.name().firstName() + Keys.TAB)
                .sendKeys(faker.name().lastName() + Keys.TAB)
                .sendKeys(faker.internet().emailAddress() + Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone() + Keys.TAB)
                .sendKeys(faker.internet().password() + Keys.TAB)
                .sendKeys(faker.internet().password() + Keys.TAB).perform();

    }
}
