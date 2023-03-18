package com.kraft.tests.day_12;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.kraft.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {

    ExtentReports report;

    ExtentHtmlReporter htmlReporter;

    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp() {
        //classı çağıralım
        report=new ExtentReports();

        //raporun path (yol) oluşturalım
        String projectpath=System.getProperty("user.dir");
        String reportPath=projectpath+"/test-output/report.html";

        //HTML raporumuzu path ile oluşturalım
        htmlReporter=new ExtentHtmlReporter(reportPath);

        //HTML raporumuzu report nesnesiyle ilişkilendirelim
        report.attachReporter(htmlReporter);

        //raporun başlığını düzenleyelim
        htmlReporter.config().setReportName("Smoke Testi");

        report.setSystemInfo("Enviroment","UAT");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Specialist","UmutIhsan");
        report.setSystemInfo("PO","Ferid Uluçınar");
    }

    @Test
    public void testName() {
        //mevcuut testimizin ismini girelim
        extentLogger=report.createTest("TC001_DemoTest");

        //test adımlarımızı girelim
        extentLogger.info("Chrome browserı aç");
        extentLogger.info("Web sitesine git "+ConfigurationReader.get("url"));
        extentLogger.info("Emaili gir");
        extentLogger.info("Şifreyi gir");
        extentLogger.info("Logine bas");
        extentLogger.info("Siteye girildiğini kullanıcı adı "+ConfigurationReader.get("userName")+" ile doğrula");

        extentLogger.pass("PASSED");
    }

    @AfterMethod
    public void tearDown() {
        report.flush();

    }
}
