package org.atyeti.jsonUpdatess.usingJsonParser;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;

import com.fasterxml.jackson.core.JsonToken;
import java.io.File;
import java.io.IOException;

public class JsonParserExamplePrintEmpID {
    public static void main(String[] args) throws IOException {
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(new File("src/main/resources/data_for_jsonParser/users.json"));
        int empId = 0;
        String name = "";

        while (parser.nextToken() != null) {

            if (parser.currentToken() == JsonToken.FIELD_NAME) {

                String field = parser.getCurrentName();
                parser.nextToken();

                if ("empId".equals(field)) {
                    empId = parser.getIntValue();
                }

                if ("name".equals(field)) {
                    name = parser.getText();
                }
            }

            if (parser.currentToken() == JsonToken.END_OBJECT) {
                System.out.println(empId + " " + name);
            }
        }



    }
}