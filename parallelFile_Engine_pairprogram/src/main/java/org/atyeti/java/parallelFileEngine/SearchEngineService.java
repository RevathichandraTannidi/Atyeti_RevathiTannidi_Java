package org.atyeti.java.parallelFileEngine;

import org.atyeti.java.parallelFileEngine.collector.ResultCollector;
import org.atyeti.java.parallelFileEngine.file.FileLoader;
import org.atyeti.java.parallelFileEngine.logging.SearchLogger;
import org.atyeti.java.parallelFileEngine.reporter.ReportGenerator;
import org.atyeti.java.parallelFileEngine.task.FileSearchTask;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class SearchEngineService {

     // keywordsInput: a comma-separated string, or a single word. Accepts comma or semicolon separators.

    public void search(String directoryPath, String keywordsInput, int threadCount) throws Exception {
        Path dir = Paths.get(directoryPath);
        if (!Files.exists(dir) || !Files.isDirectory(dir)) {
            throw new IllegalArgumentException("Invalid directory: " + directoryPath);
        }

        // parse keywords: split by commas or semicolons and trim; omit empties
        List<String> keywords = parseKeywords(keywordsInput);
        if (keywords.isEmpty()) {
            System.out.println("No keywords provided.");
            return;
        }

        List<Path> files = FileLoader.getTextFiles(dir);
        if (files.isEmpty()) {
            System.out.println("No readable text files found.");
            return;
        }

        int threads = threadCount > 0 ? threadCount : Runtime.getRuntime().availableProcessors();
        System.out.println("Searching for '" + keywords + "' in " + files.size() + " files using " + threads + " threads.\n");

        ExecutorService executor = Executors.newFixedThreadPool(threads);
        ResultCollector collector = new ResultCollector();

        for (Path file : files) {
            executor.submit(new FileSearchTask(file, keywords, collector));
        }

        shutdownExecutor(executor);
        ReportGenerator.generateSummary(collector);
    }

    private List<String> parseKeywords(String input) {
        if (input == null) return List.of();
        String[] parts = input.split("[,;]+");
        List<String> out = new ArrayList<>();
        for (String p : parts) {
            String t = p.trim();
            if (!t.isEmpty()) out.add(t);
        }
        return out;
    }

    private void shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            SearchLogger.logError("Executor interrupted during shutdown", e);
        }
    }
}
