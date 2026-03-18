package org.atyeti.jsonUpdates;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.atyeti.jsonUpdates.model.UpdateRequest;
import org.atyeti.jsonUpdates.model.User;
import org.atyeti.jsonUpdates.service.JsonUpdateService;
import org.atyeti.jsonUpdates.util.JsonFileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        ObjectMapper mp = new ObjectMapper();

  File userFile = JsonFileReader.getUsersFile();

        User[] users = mp.readValue(userFile, User[].class);

        List<User> userList =new ArrayList<>(Arrays.asList(users));

        File updateFile =JsonFileReader.getUpdateFile();

        UpdateRequest[] updates = mp.readValue(updateFile, UpdateRequest[].class);

        List<UpdateRequest> updateList = Arrays.asList(updates);

        JsonUpdateService service= new JsonUpdateService();
        service.applyUpdates(userList,updateList);
        mp.writerWithDefaultPrettyPrinter().writeValue(userFile, userList);
        System.out.println("\n after update \n");
        for (User us:userList)
        {
            System.out.println(us.getId()+" "+ us.getName()+" "+ us.getCity());
        }
    }
}