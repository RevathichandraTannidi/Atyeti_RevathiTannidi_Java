package org.atyeti.java.parallelFileEngine.collector;

import org.atyeti.java.parallelFileEngine.model.SearchError;

import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ResultCollector {

    // file -> (keyword -> count)
    private final ConcurrentHashMap<Path, ConcurrentHashMap<String, Integer>> multiResults = new ConcurrentHashMap<>();

    // errors encountered during search
    private final ConcurrentLinkedQueue<SearchError> errors = new ConcurrentLinkedQueue<>();

    // Store per-file per-keyword counts (thread-safe)
    public void addMultiResult(Path file, Map<String, Integer> counts) {
        // copy into concurrent map to be safe for later aggregation/reading
        multiResults.put(file, new ConcurrentHashMap<>(counts));
    }

    public void addError(Path file, String reason) {
        errors.add(new SearchError(file, reason));
    }

    public ConcurrentHashMap<Path, ConcurrentHashMap<String, Integer>> getResults() {
        return multiResults;
    }

    public ConcurrentLinkedQueue<SearchError> getErrors() {
        return errors;
    }

    // Aggregate totals for all keywords across all files.
    public ConcurrentHashMap<String, Integer> aggregateTotals() {
        ConcurrentHashMap<String, Integer> totals = new ConcurrentHashMap<>();
        for (ConcurrentHashMap<String, Integer> perFile : multiResults.values()) {
            for (Map.Entry<String, Integer> e : perFile.entrySet()) {
                totals.merge(e.getKey(), e.getValue(), Integer::sum);
            }
        }
        return totals;
    }
}
