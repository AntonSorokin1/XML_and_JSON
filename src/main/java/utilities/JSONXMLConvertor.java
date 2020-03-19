package utilities;

import org.json.XML;

public class JSONXMLConvertor {
    public String XMLToJSON(String XMLString) {
        return XML.toJSONObject(XMLString).toString(4);
    }
}
