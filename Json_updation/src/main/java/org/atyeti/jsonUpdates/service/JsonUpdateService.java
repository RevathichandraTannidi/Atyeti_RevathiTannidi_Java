package org.atyeti.jsonUpdates.service;

import org.atyeti.jsonUpdates.model.UpdateRequest;
import org.atyeti.jsonUpdates.model.User;

import java.util.List;

public class JsonUpdateService {

    public void applyUpdates(List<User> userList, List<UpdateRequest> updateList) {

        for (UpdateRequest update : updateList) {

            boolean found = false;

            for (User user : userList) {

                if (user.getId() == update.getId()) {

                    if (update.getName() != null) {
                        user.setName(update.getName());
                    }

                    if (update.getAge() != null) {
                        user.setAge(update.getAge());
                    }

                    if (update.getCity() != null) {
                        user.setCity(update.getCity());
                    }

                    if (update.getDepartment() != null) {
                        user.setDepartment(update.getDepartment());
                    }

                    found = true;
                    break;
                }
            }

            // Add new user if not found
            if (!found) {
                User newUser = new User();

                newUser.setId(update.getId());
                newUser.setName(update.getName());
                newUser.setAge(update.getAge() != null ? update.getAge() : 0);
                newUser.setCity(update.getCity());
                newUser.setDepartment(update.getDepartment());

                userList.add(newUser);
            }
        }
    }
}