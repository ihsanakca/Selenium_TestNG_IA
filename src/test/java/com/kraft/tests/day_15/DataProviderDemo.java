package com.kraft.tests.day_15;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {


    @DataProvider (name = "OgrenciSinavNotlari")
    public Object[][] testData(){
        String[][] data={
                {"Hasan","50","70"},
                {"Ali","70","80"},
                {"Mehmet","80","70"}
        };
        return data;
    }

    @Test(dataProvider = "OgrenciSinavNotlari")
    public void testDataProvider(String ad,String vize, String finalNot){
        System.out.println(ad+" "+vize+" "+finalNot);
    }
}
