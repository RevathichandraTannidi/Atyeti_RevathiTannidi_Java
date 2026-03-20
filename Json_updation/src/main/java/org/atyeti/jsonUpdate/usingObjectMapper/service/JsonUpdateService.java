package org.atyeti.jsonUpdate.usingObjectMapper.service;

import org.atyeti.jsonUpdate.usingObjectMapper.model.Address;
import org.atyeti.jsonUpdate.usingObjectMapper.model.UpdateRequest;
import org.atyeti.jsonUpdate.usingObjectMapper.model.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUpdateService {

    public void applyUpdates(List<User> userList, List<UpdateRequest> updateList) {

        Map<Integer, User> userMap = new HashMap<>();

        for (User user : userList) {
            userMap.put(user.getId(), user);
        }

        for (UpdateRequest update : updateList) {
            User user = userMap.get(update.getId());
            if (user != null) {

                if (update.getName() != null) {
                    user.setName(update.getName());
                }

                if (update.getAge() != null) {
                    user.setAge(update.getAge());
                }

                if (update.getCity() != null) {
                    user.setCity(update.getCity());
                }


                //
                if (update.getDepartment() != null) {
                    user.setDepartment(update.getDepartment());
                }

                if (update.getAddress() != null) {

                    if (user.getAddress() == null) {
                        user.setAddress(new Address());
                    }

                    if (update.getAddress().getStreet() != null) {
                        user.getAddress().setStreet(update.getAddress().getStreet());
                    }

                    if (update.getAddress().getArea() != null) {
                        user.getAddress().setArea(update.getAddress().getArea());
                    }

                    if (update.getAddress().getPincode() != null) {
                        user.getAddress().setPincode(update.getAddress().getPincode());
                    }
                }

            } else {

                User newUser = new User();

                newUser.setId(update.getId());
                newUser.setName(update.getName());
                newUser.setAge(update.getAge() != null ? update.getAge() : 0);
                newUser.setCity(update.getCity());
                newUser.setDepartment(update.getDepartment());

                userList.add(newUser);
                userMap.put(newUser.getId(), newUser);
            }
        }
    }
}