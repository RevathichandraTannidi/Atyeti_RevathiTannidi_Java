package org.atyeti.jsonUpdatess.usingJsonParser;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashSet;
import java.util.Set;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class StreamUpdateWithFile {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = new JsonFactory();

        File usersFile = new File("src/main/resources/data_for_jsonParser/user_emp.json");
        File updatesFile = new File("src/main/resources/data_for_jsonParser/updateRequest_emp.json");
        File outputFile = new File("src/main/resources/data_for_jsonParser/updated_users_emp.json");


        ArrayNode updatesArray = (ArrayNode) mapper.readTree(updatesFile);

        Map<Integer, JsonNode> updateMap = new HashMap<>();
        for (JsonNode upd : updatesArray) {
            updateMap.put(upd.get("empId").asInt(), upd);
        }


        JsonParser parser = factory.createParser(usersFile);


        JsonGenerator generator = factory.createGenerator(outputFile, JsonEncoding.UTF8);
generator.setCodec(mapper);
        generator.writeStartArray();

        Set<Integer> processedIds = new HashSet<>();
        while (parser.nextToken() != null) {

            if (parser.currentToken() == JsonToken.START_OBJECT) {

                JsonNode user = mapper.readTree(parser);
                int id = user.get("empId").asInt();

                // Apply update if exists
                if (updateMap.containsKey(id)) {

                    ObjectNode userObj = (ObjectNode) user;
                    JsonNode update = updateMap.get(id);

                    update.fieldNames().forEachRemaining(field -> {
                        if (!field.equals("empId")) {
                            userObj.set(field, update.get(field));
                        }
                    });
                    processedIds.add(id);
                }


                generator.writeObject(user);
            }
        }

        //  Add new users (not processed)
        for (JsonNode upd : updatesArray) {

            int id = upd.get("empId").asInt();

            if (!processedIds.contains(id)) {

                // add full update object as new user
                generator.writeObject(upd);
            }
        }

        generator.writeEndArray();

        parser.close();
        generator.close();

        System.out.println("Updated file created: updated_users.json");
    }
}