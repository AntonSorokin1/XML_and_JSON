package tasks;

import utilities.StaxStreamProcessor;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class XMLTask {
    public void start() {
        try (StaxStreamProcessor processor = new StaxStreamProcessor(new FileInputStream(new File("resources/xml/SomeShop.xml")))) {
            while (processor.startElement("product", "categories")) {
                System.out.println(processor.getAllAttributes());
            }
        }
        catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
