package org.atyeti.multiThreaded_json_logs.util;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.atyeti.multiThreaded_json_logs.model.LogEntry;

public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static LogEntry parse(JsonNode node) {
        try {
            return mapper.convertValue(node, LogEntry.class);
        } catch (Exception e) {
            return null;
        }
    }
}