package org.atyeti.jsonUpdatess.usingJsonParser;
import com.fasterxml.jackson.core.*;
import java.io.File;

public class StreamingUpdateExample {

    public static void main(String[] args) throws Exception {

        JsonFactory factory = new JsonFactory();

        JsonParser parser = factory.createParser(new File("src/main/resources/data_for_jsonParser/users.json"));
        JsonGenerator generator = factory.createGenerator(
                new File("src/main/resources/data_for_jsonParser/updated_users.json"),
                JsonEncoding.UTF8
        );

        generator.writeStartArray();

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

                // 🔥 Update logic
                if (empId == 101) {
                    name = "revathi chandra tannidi";
                }
                if (empId == 102) {
                    name = " Achyuth thota ";
                }

                // 🔥 Write updated object
                generator.writeStartObject();
                generator.writeNumberField("empId", empId);
                generator.writeStringField("name", name);
                generator.writeEndObject();
            }
        }

        generator.writeEndArray();

        parser.close();
        generator.close();

        System.out.println("Update done!");
    }
}