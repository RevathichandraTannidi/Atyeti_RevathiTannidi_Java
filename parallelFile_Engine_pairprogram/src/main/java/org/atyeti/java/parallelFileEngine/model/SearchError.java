package org.atyeti.java.parallelFileEngine.model;

import java.nio.file.Path;
import java.util.Objects;

public class SearchError {
    private final Path file;
    private final String reason;

    public SearchError(Path file, String reason) {
        this.file = file;
        this.reason = reason;
    }

    public Path getFile() {
        return file;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchError that = (SearchError) o;
        return Objects.equals(file, that.file) && Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, reason);
    }

    @Override
    public String toString() {
        return "SearchError{file=" + file + ", reason='" + reason + "'}";
    }
}