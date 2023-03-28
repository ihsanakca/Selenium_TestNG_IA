package com.kraft.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.ConfigurationReader;
import com.kraft.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    static protected ExtentReports report;

    protected ExtentHtmlReporter htmlReporter;

    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest() {
        //classı çağıralım
        report = new ExtentReports();

        //raporun path (yol) oluşturalım
        String projectpath = System.getProperty("user.dir");
        String reportPath = projectpath + "/test-output/report.html";

        //HTML raporumuzu path ile oluşturalım
        htmlReporter = new ExtentHtmlReporter(reportPath);

        //HTML raporumuzu report nesnesiyle ilişkilendirelim
        report.attachReporter(htmlReporter);

        //raporun başlığını düzenleyelim
        htmlReporter.config().setReportName("Smoke Testi");

        report.setSystemInfo("Enviroment", "UAT");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test Specialist", "UmutIhsan");
        report.setSystemInfo("PO", "Ferid Uluçınar");
    }

    @AfterTest
    public void tearDownTest() {
        report.flush();
       // Driver.closeDriver();
    }


    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        //Eğer test başarısız olursa
        if (result.getStatus() == ITestResult.FAILURE) {
            //başarısız testin adını alalım
            extentLogger.fail(result.getName());
            //ekran görüntüsü (ss) alalım ve ekran görüntüsünün kayıt edileceği yeri belirleyelim..
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());
            //ekran görüntüsünü rapora ekleyelim
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            //hata logunu (exception logs) raporun içine koyalım
            extentLogger.fail(result.getThrowable());
        }

        Driver.closeDriver();
    }

    @AfterClass
    public void tearDownClass() {
        // Driver.closeDriver();
    }
}
