package com.kraft.tests.Day_16;

import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToExcel2 {

    SXSSFWorkbook workbook;
    SXSSFSheet sheet;
    SXSSFRow row;
    SXSSFCell cell;

    public void writeToExcel_2(String path, String sheetName) throws IOException {

        FileOutputStream fos=new FileOutputStream(path);

        workbook=new SXSSFWorkbook();
        sheet=workbook.createSheet(sheetName);

        for (int i = 0; i < 10; i++) {
            row=sheet.createRow(i);
            for (int j = 0; j < 10; j++) {
                cell=row.createCell(j);
                String result=Integer.toString((i+1)*(j+1));
                cell.setCellValue((i+1)+"*"+(j+1)+"="+result);
            }
        }
        workbook.write(fos);
        fos.close();
    }

    @Test
    public void test1() throws IOException {
        writeToExcel_2("src/test/resources/deneme.xlsx","Sayfa3");
    }
}
