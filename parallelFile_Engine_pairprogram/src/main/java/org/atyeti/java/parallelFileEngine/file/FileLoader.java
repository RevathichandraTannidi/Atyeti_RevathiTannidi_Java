package org.atyeti.java.parallelFileEngine.file;

import org.atyeti.java.parallelFileEngine.logging.SearchLogger;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public static List<Path> getTextFiles(Path directory) {

        //Converts path to file
        List<Path> files = new ArrayList<>();
        File dir = directory.toFile();

        //validates the directory
        if (!dir.exists() || !dir.isDirectory()) {
            SearchLogger.logError("Directory not found: " + directory);
            return files;
        }


        searchFilesRecursively(dir, files);
        return files;
    }


    private static void searchFilesRecursively(File currentFolder, List<Path> result) {

        //get all   items inside the folder also
        File[] items = currentFolder.listFiles();

        //if system cannot access to can skip also
        if (items == null) {
            SearchLogger.logError("Cannot read folder: " + currentFolder.getAbsolutePath());
            return;
        }
//If folder → recursive call.
        for (File item : items) {
            if (item.isDirectory()) {
                searchFilesRecursively(item, result); //recursion
            } else if (item.isFile() && item.canRead()) {
//If file → check extension → add to list.
                Path filePath = item.toPath();
                if (FileTypeValidator.isTextFile(filePath)) {
                    result.add(filePath);
                }
            }
        }
    }
}