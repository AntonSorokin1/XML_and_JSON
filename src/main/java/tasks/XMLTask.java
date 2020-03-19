package tasks;

import utilities.JSONXMLConvertor;
import utilities.StaxStreamProcessor;

import javax.xml.stream.XMLStreamException;
import java.io.*;

public class XMLTask {
    public void start() {
        try (StaxStreamProcessor processor = new StaxStreamProcessor(new FileInputStream(new File("src/main/resources/xml/SomeShop.xml")))) {
            while (processor.startElement("product", "categories")) {
                System.out.println(processor.getAllAttributes());
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }

        JSONXMLConvertor jsonxmlConvertor = new JSONXMLConvertor();
        try (BufferedReader br = new BufferedReader(new FileReader(new File("src/main/resources/xml/SomeShop.xml")))) {
            StringBuilder sb = new StringBuilder();
            String input;
            while ((input = br.readLine()) != null) {
                sb.append(input);
            }
            System.out.println(jsonxmlConvertor.XMLToJSON(sb.toString()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
