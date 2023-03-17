package com.kraft.tests.day_10;

import com.kraft.pages.HBPages.HBHomePage;
import com.kraft.pages.HBPages.KadinBluzPage;
import com.kraft.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HepsiBuradaTest2 extends TestBase {

    HBHomePage hbHomePage=new HBHomePage();
    KadinBluzPage kadinBluzPage=new KadinBluzPage();

    @Test
    public void test2(){
        hbHomePage.clickCookies();
        hbHomePage.navigateTabToModule("Moda","Bluz");
        Assert.assertTrue(kadinBluzPage.kadinBuluzpageTitle.getText().contains("Bluz"));
    }
}
