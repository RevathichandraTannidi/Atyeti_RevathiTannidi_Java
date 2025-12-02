package org.atyeti.java.parallelFileEngine.model;


import java.nio.file.Path;
import java.util.Objects;

public class SearchResult {
    private final Path file;
    private final int matchCount;

    public SearchResult(Path file, int matchCount) {
        this.file = file;
        this.matchCount = matchCount;
    }

    public Path getFile() {
        return file;
    }

    public int getMatchCount() {
        return matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchResult that = (SearchResult) o;
        return matchCount == that.matchCount && Objects.equals(file, that.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, matchCount);
    }

    @Override
    public String toString() {
        return "SearchResult{file=" + file + ", matchCount=" + matchCount + "}";
    }
}