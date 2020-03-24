package tasks;

import entity.Shop;
import utilities.StaxStreamProcessor;
import utilities.JSONObjectConverter;
import utilities.XMLObjectConverter;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.*;

public class XMLTask {
    public void start() {
        // XML-/JSON-file
        File xmlFile = new File("src/main/resources/xml/SomeShop.xml");
        File jsonFile = new File("src/main/resources/json/SomeShop.json");

        // Read XML attributes
        try (StaxStreamProcessor processor = new StaxStreamProcessor(new FileInputStream(xmlFile))) {
            while (processor.startElement("product", "subCategory")) {
                System.out.println(processor.getAllAttributes());
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }

        // XML-Object-JSON Converter
        try {
            // Converters
            XMLObjectConverter xmlObjectConverter = new XMLObjectConverter();
            JSONObjectConverter jsonObjectConverter = new JSONObjectConverter();

            // XML to Object
            Shop xmlShop = xmlObjectConverter.XMLToObject(xmlFile);
            System.out.println(xmlShop.toString());
            // Object to XML
            String xmlString = xmlObjectConverter.ObjectToXML(xmlShop);
            System.out.println(xmlString);

            // JSON to Object
            Shop jsonShop = jsonObjectConverter.jsonToObject(jsonFile);
            System.out.println(jsonShop.toString());
            // Object to JSON
            String jsonString = jsonObjectConverter.objectToJSON(jsonShop);
            System.out.println(jsonString);

            // XML to JSON
            String convertedJSONString = jsonObjectConverter.objectToJSON(xmlObjectConverter.XMLToObject(xmlFile));
            System.out.println(convertedJSONString);
            // JSON to XML
            String convertedXMLString = xmlObjectConverter.ObjectToXML(jsonObjectConverter.jsonToObject(jsonFile));
            System.out.println(convertedXMLString);
        }
        catch (JAXBException | IOException e) {
            e.printStackTrace();
        }

    }
}
