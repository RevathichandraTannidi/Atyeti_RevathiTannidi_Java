package org.atyeti.java.parallelFileEngine;

import org.atyeti.java.parallelFileEngine.logging.SearchLogger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter directory path: ");
            String dir = scanner.nextLine().trim();
            if (dir.isEmpty()) {
                System.out.println("Directory is required.");
                return;
            }

            System.out.print("Enter search keyword: ");
            String keyword = scanner.nextLine().trim();
            if (keyword.isEmpty()) {
                System.out.println("Keyword is required.");
                return;
            }

            System.out.print("Enter number of threads (press Enter for default): ");
            String threadInput = scanner.nextLine().trim();
            int threads = -1;
            if (!threadInput.isEmpty()) {
                try {
                    threads = Integer.parseInt(threadInput);
                    if (threads <= 0) {
                        System.out.println("Thread count must be positive. Using default.");
                        threads = -1;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Using default.");
                    threads = -1;
                }
            }

            SearchEngineService service = new SearchEngineService();
            service.search(dir, keyword, threads);

        } catch (Exception e) {
            SearchLogger.logError("Application failed", e);
            System.err.println("Error: " + (e.getMessage() != null ? e.getMessage() : "Unknown error"));
            System.err.println("Check error.log for details.");
        } finally {
            scanner.close();
        }
    }
}