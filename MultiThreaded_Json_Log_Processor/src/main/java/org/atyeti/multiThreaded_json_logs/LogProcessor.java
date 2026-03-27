package org.atyeti.multiThreaded_json_logs;

import org.atyeti.multiThreaded_json_logs.model.LogEntry;
import org.atyeti.multiThreaded_json_logs.service.LogService;
import org.atyeti.multiThreaded_json_logs.util.JsonUtil;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.concurrent.*;

public class LogProcessor {

    public static void main(String[] args) {

        String filePath = "src/main/resources/logs.json";

        int threads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        LogService service = new LogService();
        ObjectMapper mapper = new ObjectMapper();


        List<JsonNode> updatedLogs = new CopyOnWriteArrayList<>();

        long start = System.currentTimeMillis();

        try {

            JsonNode root = mapper.readTree(new File(filePath));

            for (JsonNode node : root) {

                executor.submit(() -> {
                    try {

                        LogEntry log = JsonUtil.parse(node);

                        service.process(log);
                        JsonNode updated = service.updateLog(node);

                        updatedLogs.add(updated);

                    } catch (Exception e) {
                        System.out.println("Failed to process node: " + node);
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();

        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        service.printResults();


        service.writeToJsonFile("src/main/resources/outputlogs.json");

        //  Write updated logs file
        writeUpdatedLogs(updatedLogs, "src/main/resources/updated_logs.json");

        long end = System.currentTimeMillis();
        System.out.println("\n Time taken: " + (end - start) + " ms");
    }


    public static void writeUpdatedLogs(List<JsonNode> logs, String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(path), logs);

            System.out.println(" Updated logs written to: " + path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}