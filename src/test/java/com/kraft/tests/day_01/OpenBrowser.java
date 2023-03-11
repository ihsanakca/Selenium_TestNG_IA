package com.kraft.tests.day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();

        driver.get("https://www.google.com");

        String title = driver.getTitle();
        System.out.println("title = " + title);
        String expected="Google";

        if (title.equals(expected)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

//        driver.manage().window().maximize();
//        driver.manage().window().fullscreen();

//        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());
//        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());

        driver.manage().window().setPosition(new Point(-1000,0));
       // driver.manage().window().setSize(new Dimension(900,600));
        driver.manage().window().maximize();


    }
}
