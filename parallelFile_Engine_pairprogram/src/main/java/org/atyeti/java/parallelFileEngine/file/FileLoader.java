package org.atyeti.java.parallelFileEngine.file;

import org.atyeti.java.parallelFileEngine.logging.SearchLogger;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public static List<Path> getTextFiles(Path directory) {
        List<Path> files = new ArrayList<>();
        File dir = directory.toFile();

        if (!dir.exists() || !dir.isDirectory()) {
            SearchLogger.logError("Directory not found: " + directory);
            return files;
        }

        searchFilesRecursively(dir, files);
        return files;
    }


    private static void searchFilesRecursively(File currentFolder, List<Path> result) {
        File[] items = currentFolder.listFiles();
        if (items == null) {

            SearchLogger.logError("Cannot read folder: " + currentFolder.getAbsolutePath());
            return;
        }

        for (File item : items) {
            if (item.isDirectory()) {

                searchFilesRecursively(item, result);
            } else if (item.isFile() && item.canRead()) {

                Path filePath = item.toPath();
                if (FileTypeValidator.isTextFile(filePath)) {
                    result.add(filePath);
                }
            }
        }
    }
}