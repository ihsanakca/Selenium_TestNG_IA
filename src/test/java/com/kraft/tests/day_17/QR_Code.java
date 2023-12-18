package com.kraft.tests.day_17;


import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.kraft.pages.LoginPage;
import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class QR_Code {
    WebDriver driver;

    @Test
    public void QRTest() throws IOException, NotFoundException {
        driver= Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://goqr.me/");

        String input="https://www.krafttechexlab.com/login";

        WebElement textArea = driver.findElement(By.id("qrcode-field-text-text"));

        textArea.sendKeys(input);

        BrowserUtils.waitFor(2);

        WebElement image=driver.findElement(By.id("qrcode-preview-image"));
        BrowserUtils.waitForVisibility(image,10);

        String qrCodeURL = image.getAttribute("src");


        URL url=new URL(qrCodeURL);

        BufferedImage bufferedImage= ImageIO.read(url);

        LuminanceSource luminanceSource=new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap binaryBitmap=new BinaryBitmap(new HybridBinarizer(luminanceSource));

        Result result=new MultiFormatReader().decode(binaryBitmap);
        String text = result.getText();

        System.out.println("text = " + text);
        driver.get(text);


        driver.close();

    }

    @Test
    public void QRTest2() throws IOException, NotFoundException {
        driver= Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://qrcode.tec-it.com/en");

        driver.findElement(By.xpath("//a[text()='Accept']")).click();

        String url="ada";

        WebElement textArea = driver.findElement(By.xpath("//textarea"));

        textArea.clear();
        textArea.sendKeys(url);

        driver.findElement(By.xpath("//a[text()='Refresh']")).click();
        BrowserUtils.waitFor(3);

        WebElement image=driver.findElement(By.xpath("//img[@alt='QR Code']"));
        BrowserUtils.waitForVisibility(image,10);

        String qrCodeURL = image.getAttribute("src");

        BrowserUtils.waitFor(3);
        URL url1=new URL(qrCodeURL);

        BufferedImage bufferedImage= ImageIO.read(url1);

        LuminanceSource luminanceSource=new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap binaryBitmap=new BinaryBitmap(new HybridBinarizer(luminanceSource));

        Result result=new MultiFormatReader().decode(binaryBitmap);
        String text = result.getText();

        System.out.println("text = " + text);
      //  driver.get(text);

        BrowserUtils.waitFor(3);
        driver.close();

    }
}
