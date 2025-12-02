package org.atyeti.java.parallelFileEngine.task;


import org.atyeti.java.parallelFileEngine.collector.ResultCollector;
import org.atyeti.java.parallelFileEngine.exception.FileProcessingException;
import org.atyeti.java.parallelFileEngine.logging.SearchLogger;
import org.atyeti.java.parallelFileEngine.model.SearchError;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;

public class FileSearchTask implements Runnable {
    private final Path file;
    private final String keyword;
    private final ResultCollector collector;
    private static final AtomicInteger THREAD_ID = new AtomicInteger(1);

    public FileSearchTask(Path file, String keyword, ResultCollector collector) {
        this.file = file;
        this.keyword = keyword;
        this.collector = collector;
    }

    @Override
    public void run() {
        int id = THREAD_ID.getAndIncrement();
        String threadName = "Thread-" + id;
        SearchLogger.logInfo("[" + threadName + "] Searching in: " + file.getFileName());

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            int matches = 0;
            while ((line = reader.readLine()) != null) {
                if (line.contains(keyword)) matches++;
            }

            if (matches > 0) {
                collector.addResult(file, matches);
                SearchLogger.logInfo("[" + threadName + "] Found " + matches + " matches in: " + file.getFileName());
            }

        } catch (SecurityException e) {
            handleError(threadName, "Access denied", e);
        } catch (IOException e) {
            handleError(threadName, "Read failed", e);
        } catch (Exception e) {
            handleError(threadName, "Unexpected error", e);
        }
    }

    private void handleError(String threadName, String reason, Exception e) {
        SearchLogger.logError("[" + threadName + "] " + reason + ": " + file, e);
        collector.addError(file, String.valueOf(new SearchError(file,reason)));
    }
}