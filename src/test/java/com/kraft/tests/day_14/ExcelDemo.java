package com.kraft.tests.day_14;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDemo {

    public String readFromExcelCell(String path,String sheet,int row,int column) throws IOException {

       // File file=new File(path);
        FileInputStream fis=new FileInputStream(path);
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sheet1 = wb.getSheet(sheet);
        String s = sheet1.getRow(row).getCell(column).toString();
        return s;
    }

    @Test
    public void test1() throws IOException {
        System.out.println(readFromExcelCell("src/test/resources/LoginList.xlsx", "QaTeam2", 3, 1));
    }
}
