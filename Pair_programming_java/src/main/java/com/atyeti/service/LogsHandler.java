package com.atyeti.service;

import com.atyeti.pojo.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LogsHandler {

    public static void filesHandling() {

        final List<String> filePaths = new ArrayList<>();
        final String directoryPath = "C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\Pair_programming_java\\src\\main\\logsfiles";

        File directoryFiles = new File(directoryPath);
        File[] files = directoryFiles.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().endsWith(".log")) {
                    filePaths.add(file.getAbsolutePath());
                }
            }
        }

        List<Log> logs = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss,SSS");

        for (String path : filePaths) {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(" - ", 3);
                    if (parts.length == 3) {
                        LocalDateTime timestamp = LocalDateTime.parse(parts[0].trim(), formatter);
                        String loglevel = parts[1].trim();
                        String message = parts[2].trim();

                        Log log = new Log(timestamp, loglevel, message);
                        logs.add(log);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error file: " + path);

            } catch (Exception e) {
                System.out.println("Error line in file: " + path);

            }
        }

        for (Log log : logs) {
            System.out.println(log);
        }

    }


}
