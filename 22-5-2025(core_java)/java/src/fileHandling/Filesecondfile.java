package fileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Filesecondfile {
    public static void main(String[] args) {
        try {
            File obj = new File("java/src/fileHandling/run.txt");

            if (obj.createNewFile()) {
                System.out.println("New file is created: " + obj.getName());
            } else {
                System.out.println("File already exists.");
            }

            // Create a FileWriter object to write to the file
            try (FileWriter write = new FileWriter(obj)) {
                write.write("Hello, this is a test message.");
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file.");
                e.printStackTrace();
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
