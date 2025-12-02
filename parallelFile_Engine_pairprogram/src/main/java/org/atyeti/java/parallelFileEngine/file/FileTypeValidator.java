package org.atyeti.java.parallelFileEngine.file;


import java.nio.file.Path;

public class FileTypeValidator {
    public static boolean isTextFile(Path file) {
        String name = file.getFileName().toString().toLowerCase();
        return name.endsWith(".txt") || name.endsWith(".log") || name.endsWith(".csv") ||
                name.endsWith(".java") || name.endsWith(".xml") || name.endsWith(".json") ||
                name.endsWith(".yml") || name.endsWith(".properties") || name.endsWith(".py");
    }
}
