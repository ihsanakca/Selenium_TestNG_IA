package com.kraft.tests.day_18;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadFromXml {

    @Test
    public void test1(){
        try {
            // XML dosyasını okuyacak bir DocumentBuilder oluşturun
            String path="src/test/resources/test.xml";
            File file = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(file);

            // Kök elementi alın
            Element rootElement = document.getDocumentElement();

            // "element1" ve "element2" elementlerini alın
            NodeList browser = rootElement.getElementsByTagName("browser");
            NodeList email = rootElement.getElementsByTagName("email");
            NodeList password = rootElement.getElementsByTagName("password");
            NodeList url = rootElement.getElementsByTagName("url");

            // "browser" elementinin içeriğini alın
            String value1 = browser.item(0).getTextContent();
            System.out.println("Value1: " + value1);

            // "email" elementinin içeriğini ve attribute'ını alın
            String value2 = email.item(0).getTextContent();
            System.out.println("Value2: " + value2);

            // "password" elementinin içeriğini ve attribute'ını alın
            String value3 = password.item(0).getTextContent();
            System.out.println("Value3: " + value3);

            // "url" elementinin içeriğini ve attribute'ını alın
            String value4 = url.item(0).getTextContent();
            System.out.println("Value4: " + value4);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
