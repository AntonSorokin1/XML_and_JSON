package utilities;

import org.json.JSONObject;
import org.json.XML;

public class JSONXMLConvertor {
    public String XMLToJSON(String XMLString) {
        return XML.toJSONObject(XMLString).toString();
    }

    public String JSONToXML(String JSONString) {
        return XML.toString(new JSONObject(JSONString));
    }
}
