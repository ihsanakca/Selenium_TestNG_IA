package com.kraft.tests.day_18;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;

public class CSVReader {

    private static String value;

    public static String getValue(int columnNumber) {
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
               value = csvRecord.get(columnNumber); // İlk sütun

            }

            // Kullanılan kaynakları kapatın
            reader.close();
            csvParser.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
