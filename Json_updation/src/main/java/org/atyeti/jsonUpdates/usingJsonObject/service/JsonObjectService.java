package org.atyeti.jsonUpdates.usingJsonObject.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonObjectService {

    public void applyUpdate(ArrayNode usersArray, ArrayNode updatesArray) {

        for (JsonNode update : updatesArray) {

            int updateId = update.get("empId").asInt();
            boolean found = false;

            for (JsonNode user : usersArray) {

                if (user.get("empId").asInt() == updateId) {

                    ObjectNode userObj = (ObjectNode) user;

                    // 🔥 Dynamic update (no manual if conditions)
                    update.fieldNames().forEachRemaining(field -> {

                        if (!field.equals("empId")) {
                            userObj.set(field, update.get(field));
                        }
                    });

                    found = true;
                    break;
                }
            }


            if (!found) {
                ObjectNode newUser = (ObjectNode) update.deepCopy();
                usersArray.add(newUser);
            }
        }
    }
}