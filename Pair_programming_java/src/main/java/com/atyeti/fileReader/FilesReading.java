package com.atyeti.fileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FilesReading {
    private static final Logger logger=Logger.getLogger(FilesReading.class.getName());

    public static void filesHandling(String directoryPath) throws InterruptedException {
        File file = new File(directoryPath);
        if (!file.exists() || !file.isDirectory()) {
            logger.warning("Directory does not exist: "+directoryPath);
            return;
        }

        File[] files=file.listFiles((d, name) -> name.endsWith(".log")); // filter only .log files
        if (files==null || files.length==0) {
            logger.warning("No log files found in directory: "+directoryPath);
            return;
        }


        for (File file1 : files) {
            logger.info("Reading file: " + file.getName());
            Thread thread = new LogFileAnalyzer(file1);
            thread.start();
            thread.join();

        }

    }
}
