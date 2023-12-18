package com.kraft.tests.day_17;

import com.google.zxing.*;
import com.google.zxing.NotFoundException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.awt.SystemColor.menu;

public class Bar_Code {
    WebDriver driver;

    @Test
    public void test1() throws IOException, NotFoundException {
        driver = Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.barcode-generator.org/");
        BrowserUtils.waitFor(4);

        new WebDriverWait(driver, 7).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.iubenda-cs-close" +
                "-btn"))).click();
        BrowserUtils.waitFor(4);
        new Actions(driver).moveToElement(new WebDriverWait(driver, 7).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("figure#code_figure_20")))).build().perform();
        BrowserUtils.waitFor(4);
        new WebDriverWait(driver, 7).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='create" +
                "-overlay']//div[@class='inner-cell']//button[@data-choose='20' and contains(., 'Create Barcode')]"))).click();

        BrowserUtils.waitFor(4);


//        BrowserUtils.waitFor(2);
//        driver.findElement(By.className("iubenda-cs-close-btn")).click();
//        BrowserUtils.waitFor(2);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        WebElement selectElement = driver.findElement(By.xpath("//select[@id='code_selector']"));
//        Select select = new Select(selectElement);
//        List<WebElement> options = select.getOptions();
//        BrowserUtils.waitFor(4);
//
//        System.out.println("options.size() = " + options.size());
//
//        select.selectByVisibleText("Code 128 (standard)");

        driver.findElement(By.id("barcode_data")).sendKeys("abc");
        BrowserUtils.waitFor(5);
        driver.findElement(By.xpath("//button[@value='Create Barcode']")).click();
        BrowserUtils.waitFor(2);
        String barCodeURL =
                driver.findElement(By.xpath("//h2[text()='Preview Barcode']//following-sibling::img")).getAttribute(
                        "src");


        System.out.println(barCodeURL);
        URL url = new URL(barCodeURL);
        BufferedImage bufferedimage = ImageIO.read(url);
        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedimage);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
        Result result = new MultiFormatReader().decode(binaryBitmap);
        System.out.println(result.getText());
        driver.close();
    }

    @Test
    public void test2() throws IOException, NotFoundException {
        driver = Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.cognex.com/resources/interactive-tools/free-barcode-generator");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        BrowserUtils.waitFor(8);

        driver.findElement(By.id("generalModalClose")).click();

        WebElement data = driver.findElement(By.id("data"));
        data.clear();
        data.sendKeys("ihsan");


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement btn = driver.findElement(By.cssSelector("input[value=\"Generate Barcode\"]"));
        btn.click();
        BrowserUtils.waitFor(5);
        String barCodeURL = driver.findElement(By.xpath("//p//following-sibling::img")).getAttribute("src");
        //String barCodeURL=driver.findElement(By.xpath("//*[@id=\"HTML12\"]/div[1]/img[2]")).getAttribute("src");

        System.out.println(barCodeURL);
        URL url = new URL(barCodeURL);
        BufferedImage bufferedimage = ImageIO.read(url);
        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedimage);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
        Result result = new MultiFormatReader().decode(binaryBitmap);
        System.out.println(result.getText());

        driver.close();
    }

    @Test
    public void hardDropDown() throws IOException, NotFoundException {
        driver = Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.barcode-generator.org/");
        BrowserUtils.waitFor(4);

        new WebDriverWait(driver, 7).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.iubenda-cs-close" +
                "-btn"))).click();

        WebElement dropDown = driver.findElement(By.id("code_selector"));

        //style="display: none;" attribute değeri nedeniyle drop down görünmüyor.
        // Dropdown elementini görünür yap
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", dropDown);

        Select select = new Select(dropDown);

        select.selectByVisibleText("Code 128 (standard)");


            /** burası çalışıyor
             List<WebElement> options = select.getOptions();
             System.out.println("options.size() = " + options.size());
             for (WebElement option : options) {
             System.out.println("option.getAttribute(\"value\") = " + option.getAttribute("value"));
             System.out.println("option.getText() = " + option.getText());
             }

             new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(options.get(1))).click();
             */
        BrowserUtils.waitFor(4);

        driver.findElement(By.id("barcode_data")).sendKeys("ihsan");
        BrowserUtils.waitFor(5);
        driver.findElement(By.xpath("//button[@value='Create Barcode']")).click();
        BrowserUtils.waitFor(2);
        String barCodeURL =
                driver.findElement(By.xpath("//h2[text()='Preview Barcode']//following-sibling::img")).getAttribute("src");


        System.out.println(barCodeURL);
        URL url = new URL(barCodeURL);
        BufferedImage bufferedimage = ImageIO.read(url);
        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedimage);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
        Result result = new MultiFormatReader().decode(binaryBitmap);
        System.out.println(result.getText());
        driver.close();
    }

    @Test
    public void hardDropDown_2() throws IOException, NotFoundException {
        driver = Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.barcode-generator.org/");
        BrowserUtils.waitFor(4);

        new WebDriverWait(driver, 7).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.iubenda-cs-close" +
                "-btn"))).click();

        WebElement dropDown = driver.findElement(By.id("code_selector"));

        //style="display: none;" attribute değeri nedeniyle drop down görünmüyor.
        // Dropdown elementini görünür yap
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", dropDown);

        Select select = new Select(dropDown);

        select.selectByVisibleText("QR Code");


        BrowserUtils.waitFor(2);

        driver.findElement(By.id("url_text")).sendKeys("https://www.krafttechexlab.com/login");
        BrowserUtils.waitFor(5);
        driver.findElement(By.xpath("//button[@value='Create QR Code']")).click();
        BrowserUtils.waitFor(2);
        String barCodeURL =
                driver.findElement(By.cssSelector(".prevImg")).getAttribute("src");


        System.out.println(barCodeURL);
        URL url = new URL(barCodeURL);
        BufferedImage bufferedimage = ImageIO.read(url);
        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedimage);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
        Result result = new MultiFormatReader().decode(binaryBitmap);
        System.out.println(result.getText());


        driver.get(result.getText());
        BrowserUtils.waitFor(2);
        driver.close();
    }

}
