package com.kraft.tests.day_05;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Second {
    WebDriver driver;

    @Test
    public void test1() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();

        WebElement checkBox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        WebElement checkBox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        Assert.assertTrue(checkBox2.isSelected(), "Verify that checkBox 2 is selected");
        Assert.assertFalse(checkBox1.isSelected(), "Verify that checkBox 1 is NOT selected");
        Thread.sleep(2000);
        checkBox1.click();
        Thread.sleep(2000);
        checkBox2.click();
        Assert.assertFalse(checkBox2.isSelected());
        Assert.assertTrue(checkBox1.isSelected());
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void test2() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://medipol.com.tr");

        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();


        Thread.sleep(2000);
        driver.findElement(By.linkText("HASTANELERİMİZ")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("TIBBİ BİRİMLER")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("DOKTORLARIMIZ")).click();
        Thread.sleep(4000);
        driver.findElement(By.linkText("TEKNOLOJİ")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("CHECK-UP")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("EVDE SAĞLIK")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("İLETİŞİM")).click();
        Thread.sleep(2000);


        medipol("HASTANELERİMİZ");
        medipol("TIBBİ BİRİMLER");
        medipol("DOKTORLARIMIZ");
        medipol("TEKNOLOJİ");
        medipol("CHECK-UP");
        medipol("EVDE SAĞLIK");
        medipol("İLETİŞİM");

        driver.quit();

    }

    public void medipol(String text) throws InterruptedException {
        driver.findElement(By.linkText(text)).click();
        Thread.sleep(2000);
    }

    @Test
    public void test3() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");
        //cookies
        driver.findElement(By.id("btnCookie")).click();

        WebElement legumes = driver.findElement(By.xpath("//div[text()='Legumes']"));
        WebElement legumesRadio = driver.findElement(By.xpath("//div[text()='Legumes']/../input"));

        System.out.println("legumes.isSelected() = " + legumes.isSelected());
        System.out.println("legumes.isDisplayed() = " + legumes.isDisplayed());
        System.out.println("legumes.isEnabled() = " + legumes.isEnabled());
        System.out.println("\"--------------------\" = " + "--------------------");
        System.out.println("legumesRadio.isSelected() = " + legumesRadio.isSelected());
        System.out.println("legumesRadio.isDisplayed() = " + legumesRadio.isDisplayed());
        System.out.println("legumesRadio.isEnabled() = " + legumesRadio.isEnabled());
        System.out.println("\"--------------------\" = " + "--------------------");
        legumes.click();
        Thread.sleep(4000);
        System.out.println("legumes.isSelected() = " + legumes.isSelected());
        System.out.println("legumes.isDisplayed() = " + legumes.isDisplayed());
        System.out.println("legumes.isEnabled() = " + legumes.isEnabled());
        System.out.println("\"--------------------\" = " + "--------------------");
        System.out.println("legumesRadio.isSelected() = " + legumesRadio.isSelected());
        System.out.println("legumesRadio.isDisplayed() = " + legumesRadio.isDisplayed());
        System.out.println("legumesRadio.isEnabled() = " + legumesRadio.isEnabled());

        driver.quit();
    }

    @Test
    public void test4() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");
//        driver.manage().window().maximize();
//        WebElement bottomFrame = driver.findElement(By.xpath("//iframe[1]"));
//        driver.switchTo().frame(bottomFrame);
//        driver.findElement(By.xpath("//div[@id='cbb']")).click();
//        //driver.findElement(By.id("close-fixedban")).click();
//        driver.switchTo().defaultContent();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //   js.executeScript("window.scrollBy(0,450)", "");

        //driver.findElement(By.xpath("//div[@class=\"subjects-auto-complete__placeholder css-1wa3eu0-placeholder\"]")).sendKeys("sdfdsf000000000");

        WebElement sports = driver.findElement(By.cssSelector("input[id='hobbies-checkbox-1']"));
        Assert.assertFalse(sports.isSelected());

        WebElement reading = driver.findElement(By.cssSelector("input[id='hobbies-checkbox-2']"));
        WebElement music = driver.findElement(By.cssSelector("input[id='hobbies-checkbox-3']"));

        Assert.assertFalse(reading.isSelected());
        Assert.assertFalse(music.isSelected());
        Thread.sleep(3000);
        System.out.println("sports.isEnabled() = " + sports.isEnabled());
        System.out.println("sports.isDisplayed() = " + sports.isDisplayed());
        System.out.println("sports.isSelected() = " + sports.isSelected());


        js.executeScript("arguments[0].scrollIntoView(true);"
                + "arguments[0].click()", sports);
        //sports.click();
        Thread.sleep(5000);
        Assert.assertTrue(sports.isSelected());

        driver.close();
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("before method");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After method");
    }

    @BeforeClass
    public void setUpClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("After class");
    }

    @BeforeTest
    public void setUpTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void tearDownTest() {
        System.out.println("After Test");
    }

    @BeforeSuite
    public void setUpSuite() {
        System.out.println("Before Suit");
    }

    @AfterSuite
    public void tearDownSuite() {
        System.out.println("After Suit");
    }

    @BeforeGroups
    public void setUpGroups() {
        System.out.println("Before Groups");
    }

    @AfterGroups
    public void tearDownGroups() {
        System.out.println("After Groups");
    }
}
