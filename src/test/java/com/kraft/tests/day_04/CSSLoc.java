package com.kraft.tests.day_04;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.*;

public class CSSLoc {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/login");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("#email")).sendKeys("sgezer@gmail.com");

        WebElement pass=driver.findElement(By.cssSelector("input[name='password']"));
        pass.sendKeys("12345678"+ Keys.ENTER);

        //driver.findElement(By.cssSelector("button")).click();

        Thread.sleep(2000);

        driver.quit();

    }
}
