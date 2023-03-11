package com.kraft.tests.day_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();

        driver.get("https://www.google.com");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

       // driver.get("https://www.hepsiburada.com");

        driver.navigate().to("https://www.krafttechexlab.com/login");

        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        String title = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("title = " + title);
        System.out.println("currentUrl = " + currentUrl);

       // driver.close();
        driver.quit();

    }
}
