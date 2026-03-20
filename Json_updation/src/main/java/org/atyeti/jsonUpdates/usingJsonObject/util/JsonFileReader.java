package org.atyeti.jsonUpdates.usingJsonObject.util;

import java.io.FileReader;
import java.io.IOException;

public class JsonFileReader {

    public static FileReader getUsersReader() throws IOException {
        return new FileReader(
                "C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\Json_updation\\src\\main\\resources\\data_for_jsonObject\\users.json"
        );
    }

    public static FileReader getUpdatesReader() throws IOException {
        return new FileReader(
                "C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\Json_updation\\src\\main\\resources\\data_for_jsonObject\\updateRequest.json"
        );
    }
}