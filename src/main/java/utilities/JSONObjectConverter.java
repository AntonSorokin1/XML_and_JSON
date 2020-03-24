package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import entity.Shop;

import java.io.*;

public class JSONObjectConverter {
    public String objectToJSON(Shop shop) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(writer, shop);
        return writer.toString();
    }

    public Shop jsonToObject(File jsonFile) throws IOException {
        FileReader reader = new FileReader(jsonFile);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(reader, Shop.class);
    }

    public Shop jsonToObject(String jsonString) throws IOException {
        StringReader reader = new StringReader(jsonString);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(reader, Shop.class);
    }
}
