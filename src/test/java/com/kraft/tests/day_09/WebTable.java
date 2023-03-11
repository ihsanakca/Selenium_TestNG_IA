package com.kraft.tests.day_09;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTable {
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
    public void webTables() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[@id='table1']/thead//th"));
        List<WebElement> rowsOfTable = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr"));

        int numberOfColumn=columnNames.size();
        int numberOfRow=rowsOfTable.size();

        for (int i = 1; i <=numberOfRow; i++) {
            for (int j = 1; j <= numberOfColumn; j++) {
                System.out.print(dataOfCell(i, j)+" ");
            }
            System.out.println();
        }
        System.out.println(dataOfCell(3, 3));
    }

    String dataOfCell(int row,int column){

        return driver.findElement(By.xpath("//table[@id='table1']//" +
                "tbody//tr["+row+"]//td["+column+"]")).getText();

    }
}
