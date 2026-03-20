package org.atyeti.jsonUpdates.usingJsonObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.atyeti.jsonUpdates.usingJsonObject.service.JsonObjectService;
import org.atyeti.jsonUpdates.usingJsonObject.util.JsonFileReader;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

            // Step 1: Read users.json
        ArrayNode usersArray =
                (ArrayNode) mapper.readTree(JsonFileReader.getUsersReader());

        //  Step 2: Read updateRequest.json
        ArrayNode updatesArray =
                (ArrayNode) mapper.readTree(JsonFileReader.getUpdatesReader());

        //  Step 3: Apply updates
        JsonObjectService service = new JsonObjectService();
        service.applyUpdate(usersArray, updatesArray);

        //  Step 4: Print updated data
        System.out.println("Updated JSON:");
        for (JsonNode user : usersArray) {
            System.out.println(user);
        }


        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(
new File("C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\Json_updation\\src\\main\\resources\\data_for_jsonObject\\users.json"),
                        usersArray
                );
    }
}