package com.kraft.tests.day_14;

import com.kraft.utilities.ExcelUtil;
import org.testng.annotations.Test;

public class ExcelUtilDemo {

    @Test
    public void test1(){

        ExcelUtil qaTeam1 = new ExcelUtil("src/test/resources/LoginList.xlsx", "QaTeam1");

        System.out.println(qaTeam1.getColumnsNames());

        System.out.println("qaTeam1.columnCount() = " + qaTeam1.columnCount());

        String[][] dataArray = qaTeam1.getDataArray();

        for (String[] s : dataArray) {
            for (String s1 : s) {
                System.out.print(s1+" ");
            }
            System.out.println();
        }
    }
}
