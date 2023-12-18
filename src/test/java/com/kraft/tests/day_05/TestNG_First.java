package com.kraft.tests.day_05;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.*;

public class TestNG_First {
    /**
    1- Navigate to url:http://zero.webappsecurity.com/index.html
    2- click Signin
    2- Username=username, Password=password
    3- click submit
    4- navigate back
    5- click "Checking Account Activity"
    6- click "Transfer Funds"
    7- Amount input place's get the value of required attribute of amount box and print it.
    8- try to get the message of warning...("Lütfen bu alanı doldurun") if u can, print it too...
     */
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://zero.webappsecurity.com/index.html");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        WebElement signin_button = driver.findElement(By.id("signin_button"));
        signin_button.click();
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.xpath("//input[@name='user_login']"));
        username.sendKeys("username");
        Thread.sleep(2000);
        WebElement pass = driver.findElement(By.cssSelector("#user_password"));
        pass.sendKeys("password" + Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#account_activity_link")).click();
        Thread.sleep(2000);
        WebElement transfer_funds = driver.findElement(By.linkText("Transfer Funds"));
        transfer_funds.click();
        Thread.sleep(2000);
        WebElement amount = driver.findElement(By.xpath("//input[@id='tf_amount']"));
        System.out.println("amount.getAttribute(\"required\") = " + amount.getAttribute("required"));
        System.out.println("amount.getAttribute(\"validationMessage\") = " + amount.getAttribute("validationMessage"));

        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://zero.webappsecurity.com/index.html");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        WebElement signin_button = driver.findElement(By.id("signin_button"));
        signin_button.click();
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.xpath("//input[@name='user_login']"));
        username.sendKeys("username");
        Thread.sleep(2000);
        WebElement pass = driver.findElement(By.cssSelector("#user_password"));
        pass.sendKeys("password" + Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#account_activity_link")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Account Summary")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Account Activity")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Transfer Funds")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Pay Bills")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("My Money Map")).click();

        driver.quit();
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("before method");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After method");
    }
    @BeforeClass
    public void setUpClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("After class");
    }
    @BeforeTest
    public void setUpTest(){
        System.out.println("Before Test");
    }
    @AfterTest
    public void tearDownTest(){
        System.out.println("After Test");
    }

    @BeforeSuite
    public void setUpSuite(){
        System.out.println("Before Suit");
    }
    @AfterSuite
    public void tearDownSuite(){
        System.out.println("After Suit");
    }

    @BeforeGroups
    public void setUpGroups(){
        System.out.println("Before Groups");
    }
    @AfterGroups
    public void tearDownGroups(){
        System.out.println("After Groups");
    }
}
