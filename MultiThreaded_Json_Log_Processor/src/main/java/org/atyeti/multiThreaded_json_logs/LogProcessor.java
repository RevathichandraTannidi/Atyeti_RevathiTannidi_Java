package org.atyeti.multiThreaded_json_logs;

import org.atyeti.multiThreaded_json_logs.model.LogEntry;
import org.atyeti.multiThreaded_json_logs.service.LogService;
import org.atyeti.multiThreaded_json_logs.util.JsonUtil;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.concurrent.*;

public class LogProcessor {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\MultiThreaded_Json_Log_Processor\\src\\main\\resources\\logs.json";

        int threads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        LogService service = new LogService();
        ObjectMapper mapper = new ObjectMapper();

        long start = System.currentTimeMillis();

        try {

            JsonNode root = mapper.readTree(new File(filePath));

            for (JsonNode node : root) {

                executor.submit(() -> {
                    try {

                        LogEntry log = JsonUtil.parse(node);

                        service.process(log);

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

        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");
    }
}