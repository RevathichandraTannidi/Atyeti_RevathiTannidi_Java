package org.atyeti.java.parallelFileEngine.exception;

import java.nio.file.Path;

public class FileProcessingException extends Exception{
    public FileProcessingException(Path file, String reason, Throwable cause) {
        super("Failed to process file: " + file + " - " + reason, cause);
    }
}
