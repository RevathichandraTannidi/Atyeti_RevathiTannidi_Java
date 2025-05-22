package fileHandling;



import java.io.*;


public class ReaderExample {

    public static void main(String[] args) throws IOException {



        FileReader fileReader = new FileReader("C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\22-5-2025(core_java)\\java\\src\\fileHandling\\reader.txt");

        int character;

        while ((character = fileReader.read()) != -1) {

            System.out.print((char) character); // Print each character

        }

        fileReader.close();

    }

}