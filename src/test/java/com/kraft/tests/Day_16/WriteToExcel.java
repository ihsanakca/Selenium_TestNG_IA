package com.kraft.tests.Day_16;

import com.kraft.utilities.ExcelUtil;
import org.testng.annotations.Test;

public class WriteToExcel {
    ExcelUtil excelUtil=new ExcelUtil("src/test/resources/deneme.xlsx","Sayfa2");

    public void multiplicationTable(){

        for (int i = 1; i <=9 ; i++) {
            for (int j = 1; j <=10 ; j++) {
                String  result=String.valueOf(i*j);
                excelUtil.setCellData(i+"*"+j+"="+result,i-1,j-1);
            }
        }
    }

    @Test
    public void test1(){
        multiplicationTable();
    }
}
