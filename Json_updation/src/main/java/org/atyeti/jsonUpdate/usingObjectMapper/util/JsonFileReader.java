package org.atyeti.jsonUpdate.usingObjectMapper.util;

import java.io.File;

public class JsonFileReader {

    public static File getUsersFile() {

        try {
            File file = new File(
                    "C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\Json_updation\\src\\main\\resources\\data\\users.json"
            );

            if (!file.exists()) {
                throw new RuntimeException("Users file not found");
            }

            return file;

        } catch (Exception e) {
            throw new RuntimeException("Error while reading users.json", e);
        }
    }

    public static File getUpdateFile() {

        try {
            File file = new File(
                    "C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\Json_updation\\src\\main\\resources\\data\\updateRequest.json"
            );

            if (!file.exists()) {
                throw new RuntimeException("Update file not found");
            }

            return file;

        } catch (Exception e) {
            throw new RuntimeException("Error while reading updateRequest.json", e);
        }
    }
}