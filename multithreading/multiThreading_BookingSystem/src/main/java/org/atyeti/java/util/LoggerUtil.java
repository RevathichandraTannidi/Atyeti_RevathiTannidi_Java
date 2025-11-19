package org.atyeti.java.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {

    private static final String FILE = "src/main/resources/booking-log.txt";
    private static final DateTimeFormatter TS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    static {
        try {
            File f = new File(FILE);
            File parent = f.getParentFile();

            if (!parent.exists()) {
                parent.mkdirs();
            }

            if (!f.exists()) {
                f.createNewFile();
            }

        } catch (IOException e) {
            System.err.println("Failed to initialize log file: " + e.getMessage());
        }
    }

    public static synchronized void log(String msg) {
        String time = LocalDateTime.now().format(TS);
        String thread = Thread.currentThread().getName();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, true))) {
            writer.write(time + " [" + thread + "] " + msg);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Failed to write log: " + e.getMessage());
        }
    }

    public static String getLogPath() {
        return new File(FILE).getAbsolutePath();
    }
}
