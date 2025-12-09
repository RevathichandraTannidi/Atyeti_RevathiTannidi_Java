package org.atyeti.java.parallelFileEngine.logging;


import java.io.IOException;
import java.util.logging.*;

public class SearchLogger {
    private static final Logger logger = Logger.getLogger("SearchEngine");
    private static boolean initialized = false;
//Runs only ONCE when class is loaded:
    static {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void init() throws IOException {
        if (initialized) return;
        logger.setUseParentHandlers(false);//prevents duplicate console logs.

        //activity log
        FileHandler activity = new FileHandler("activity.log", true);
        activity.setLevel(Level.INFO);
        activity.setFormatter(new SimpleFormatter());
        logger.addHandler(activity);

        //error log
        FileHandler error = new FileHandler("error.log", true);
        error.setLevel(Level.SEVERE);
        error.setFormatter(new SimpleFormatter());
        logger.addHandler(error);

        initialized = true;
    }

    public static void logInfo(String msg) {
        logger.info(msg);
    }

    public static void logError(String msg, Throwable t) {
        logger.log(Level.SEVERE, msg, t);
    }

    public static void logError(String msg) {
        logger.severe(msg);
    }
}