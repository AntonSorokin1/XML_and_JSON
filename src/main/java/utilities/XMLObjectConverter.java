package utilities;

import entity.Category;
import entity.Product;
import entity.Shop;
import entity.SubCategory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

public class XMLObjectConverter {
    public String ObjectToXML(Shop shop) throws JAXBException {
        StringWriter sw = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Shop.class, Category.class, SubCategory.class, Product.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(shop, sw);
        return sw.toString();
    }

    public Shop XMLToObject(File xmlFile) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Shop.class, Category.class, SubCategory.class, Product.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Shop) unmarshaller.unmarshal(xmlFile);
    }

    public Shop XMLToObject(String xmlString) throws JAXBException {
        StringReader reader = new StringReader(xmlString);
        JAXBContext context = JAXBContext.newInstance(Shop.class, Category.class, SubCategory.class, Product.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Shop) unmarshaller.unmarshal(reader);
    }
}
