package com.kraft.tests.day_18;

import com.kraft.utilities.ConfigurationReader;
import com.kraft.utilities.Driver;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.Reader;

public class CSVTest {

    @Test
    public void test1(){
        try {
            // CSV dosyasının yolu
            String csvFilePath = "src/test/resources/credentials.csv";

            // CSV dosyasını okumak için FileReader kullanın
            Reader reader = new FileReader(csvFilePath);

            // CSVParser ile CSV dosyasını parse edin
            CSVParser csvParser = CSVFormat.DEFAULT.parse(reader);

            // Her bir satırı döngü içinde işleyin
            for (CSVRecord csvRecord : csvParser) {
                // Her bir sütunu alabilirsiniz
                String column1 = csvRecord.get(0); // İlk sütun
                String column2 = csvRecord.get(1); // İkinci sütun
                String column3 = csvRecord.get(2); // İkinci sütun
                String column4 = csvRecord.get(3); // İkinci sütun
                // ...

                // Alınan verileri istediğiniz şekilde kullanabilirsiniz
                System.out.println("Column 1: " + column1 + ", Column 2: " + column2);
                System.out.println("Column 3: " + column3 + ", Column 4: " + column4);
            }

            // Kullanılan kaynakları kapatın
            reader.close();
            csvParser.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void test2(){
      //  System.out.println("CSVReader.getValue(3) = " + CSVReader.getValue(3));
        Driver.get().manage().window().maximize();
        Driver.get().get(CSVReader.getValue(3));
        Driver.get().findElement(By.id("email")).sendKeys(CSVReader.getValue(1));
        Driver.get().findElement(By.id("yourPassword")).sendKeys(CSVReader.getValue(2));
        Driver.get().findElement(By.tagName("button")).click();
        Driver.closeDriver();
    }

    @Test
    public void test3(){

        Driver.get().manage().window().maximize();
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().findElement(By.id("email")).sendKeys(ConfigurationReader.get("userEmail"));
        Driver.get().findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("password"));
        Driver.get().findElement(By.tagName("button")).click();
        Driver.closeDriver();
    }
}
