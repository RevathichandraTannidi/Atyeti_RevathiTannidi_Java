package org.atyeti.java.parallelFileEngine.collector;

import org.atyeti.java.parallelFileEngine.model.SearchError;

import java.nio.file.Path;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ResultCollector {
    private final ConcurrentHashMap<Path, Integer> results = new ConcurrentHashMap<>();
    private final ConcurrentLinkedQueue<SearchError> errors = new ConcurrentLinkedQueue<>();

    public void addResult(Path file, int count) {
        results.put(file, count);
    }

    public void addError(Path file, String reason) {
        errors.add(new SearchError(file, reason));
    }

    public ConcurrentHashMap<Path, Integer> getResults() {
        return results;
    }
    public ConcurrentLinkedQueue<SearchError> getErrors() {
        return errors;
    }
}