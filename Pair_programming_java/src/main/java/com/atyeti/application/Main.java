package com.atyeti.application;


import com.atyeti.DatabaseHandler.DatabaseConfig;
import com.atyeti.DatabaseHandler.DatabaseConnection;
import com.atyeti.fileReader.FilesReading;



public class Main {
    private static final String directory_Path = "C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\Pair_programming_java\\src\\main\\logsfiles";

    public static void main(String[] args) throws Exception {

                try {
                    FilesReading.filesHandling(directory_Path);
                    DatabaseConfig.database();
                    DatabaseConfig.insertLog();

                } catch (Exception e) {
                    System.err.println("An error occurred: " + e.getMessage());
                }

    }
}
