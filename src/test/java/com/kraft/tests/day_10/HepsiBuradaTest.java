package com.kraft.tests.day_10;

import com.kraft.pages.HBPages.HBHomePage;
import com.kraft.pages.HBPages.KadinBluzPage;
import com.kraft.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HepsiBuradaTest extends TestBase {



    @Test
    public void test1(){
        HBHomePage hbHomePage=new HBHomePage();

        hbHomePage.clickCookies();
        hbHomePage.navigateTabToModule("Ev, Yaşam, Kırtasiye, Ofis","Ev Dekorasyon");
    }


    @Test
    public void test2(){

        HBHomePage hbHomePage=new HBHomePage();
        KadinBluzPage kadinBluzPage=new KadinBluzPage();

        hbHomePage.clickCookies();
        hbHomePage.navigateTabToModule("Moda","Bluz");
        Assert.assertTrue(kadinBluzPage.kadinBuluzpageTitle.getText().contains("Bluz"));
    }
}
