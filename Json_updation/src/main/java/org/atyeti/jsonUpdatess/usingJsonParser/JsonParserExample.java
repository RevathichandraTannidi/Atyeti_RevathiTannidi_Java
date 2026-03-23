package org.atyeti.jsonUpdatess.usingJsonParser;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;

public class JsonParserExample {

    public static void main(String[] args) throws Exception {

        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(new File("src/main/resources/data_for_jsonParser/users.json"));

        while (parser.nextToken() != null) {

            if (parser.currentToken() == JsonToken.FIELD_NAME) {

                String fieldName = parser.getCurrentName();

                if ("name".equals(fieldName)) {
                    parser.nextToken();
                    String name = parser.getText();
                    System.out.println("Name: " + name);
                }
            }
        }
        parser.close();
    }
}