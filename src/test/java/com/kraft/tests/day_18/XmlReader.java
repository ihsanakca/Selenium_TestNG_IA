package com.kraft.tests.day_18;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class XmlReader {
    public static void main(String[] args) {
        try {
            // XML dosyasını oku
            String path="src/test/resources/test.xml";
            Path xmlPath = Paths.get(path);
            String xmlContent = new String(Files.readAllBytes(xmlPath));

            // XML içeriğini parse et (bu örnek basit bir parse işlemidir)
            Map<String, String> xmlData = parseXML(xmlContent);

            // Verilere erişin
            String browser = xmlData.get("browser");
            String email = xmlData.get("email");
            String password = xmlData.get("password");
            String url = xmlData.get("url");

            // Verileri ekrana yazdır
            System.out.println("Browser: " + browser);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);
            System.out.println("URL: " + url);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static Map<String, String> parseXML(String xmlContent) {
        // Bu örnek basit bir XML parse işlemidir. Gerçek bir XML parser kullanmanız önerilir.
        Map<String, String> xmlData = new HashMap<>();
        xmlData.put("browser", getValue(xmlContent, "browser"));
        xmlData.put("email", getValue(xmlContent, "email"));
        xmlData.put("password", getValue(xmlContent, "password"));
        xmlData.put("url", getValue(xmlContent, "url"));
        return xmlData;
    }

    private static String getValue(String xmlContent, String tag) {
        String startTag = "<" + tag + ">";
        String endTag = "</" + tag + ">";
        int startIndex = xmlContent.indexOf(startTag) + startTag.length();
        int endIndex = xmlContent.indexOf(endTag);
        return xmlContent.substring(startIndex, endIndex);
    }
}
