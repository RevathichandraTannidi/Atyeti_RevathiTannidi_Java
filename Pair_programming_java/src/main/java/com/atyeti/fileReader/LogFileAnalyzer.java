package com.atyeti.fileReader;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;


public class LogFileAnalyzer extends Thread{
private static final Logger logger= Logger.getLogger(LogFileAnalyzer.class.getName());

private static String writefile="C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\Pair_programming_java\\src\\main\\java\\com\\atyeti\\duplicateFile\\duplicate.log";

    private static final AtomicInteger errorCount = new AtomicInteger(0);
    // private AtomicInteger errorCount;
    private static final AtomicInteger warnCount = new AtomicInteger(0);
    // private int warnCount = 0;
    //private int infoCount = 0;
    private static final AtomicInteger infoCount = new AtomicInteger(0);

    private final File Logfile;
    public LogFileAnalyzer( File logfile) {

        Logfile = logfile;
    }




    public static int getErrorCount() {
        return errorCount.get();
    }

    public static int getWarnCount() {
        return warnCount.get();
    }

    public static int getInfoCount() {
        return infoCount.get();
    }
    @Override
    public void run() {
        try {
            readLogFile(Logfile);
        } catch (IOException e) {
            logger.warning("Error reading log file: " + Logfile.getName());
        }
    }

    public static void readLogFile(File logFile) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(logFile));
        BufferedWriter bw=new BufferedWriter(new FileWriter(writefile,true))) {
            String line = "";


            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();


                if (line.contains("INFO")) {
                    infoCount.incrementAndGet();
                } else if (line.contains("WARNING")) {
                    warnCount.incrementAndGet();
                } else if (line.contains("ERROR")) {
                    errorCount.incrementAndGet();
                }

            }
logger.info("files are copied to duplicate file");
        } catch (IOException e) {
            logger.warning("File not found!!");

        }
    }
}
