package org.atyeti.java.parallelFileEngine.task;

import org.atyeti.java.parallelFileEngine.collector.ResultCollector;
import org.atyeti.java.parallelFileEngine.logging.SearchLogger;
import org.atyeti.java.parallelFileEngine.model.SearchError;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FileSearchTask implements Runnable {

    private final Path file;
    private final List<String> keywords;
    private final ResultCollector collector;

    private static final AtomicInteger THREAD_ID = new AtomicInteger(1);

    public FileSearchTask(Path file, List<String> keywords, ResultCollector collector) {
        this.file = file;
        this.keywords = keywords;
        this.collector = collector;
    }

    @Override
    public void run() {
        int id = THREAD_ID.getAndIncrement();
        String threadName = "Thread-" + id;

        SearchLogger.logInfo("[" + threadName + "] Searching in: " + file.getFileName());

        // Use a plain HashMap to accumulate counts for this single file (fast)
        Map<String, Integer> counts = new HashMap<>();
        // Pre-normalize keywords to lower-case for case-insensitive search
        List<String> lowerKeywords = keywords.stream().map(String::toLowerCase).toList();

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String lowerLine = line.toLowerCase();
                for (String kw : lowerKeywords) {
                    if (kw.isEmpty()) continue;
                    if (lowerLine.contains(kw)) {
                        counts.merge(kw, 1, Integer::sum);
                    }
                }
            }

            if (!counts.isEmpty()) {
                collector.addMultiResult(file, counts);
                int totalMatches = counts.values().stream().mapToInt(Integer::intValue).sum();
                SearchLogger.logInfo("[" + threadName + "] Found " + totalMatches + " matches in: " + file.getFileName());
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
        collector.addError(file, reason);
    }
}
