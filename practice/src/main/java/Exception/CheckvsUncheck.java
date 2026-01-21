package Exception;

import java.io.IOException;

public class CheckvsUncheck {
    public static void main(String[] args) throws IOException {
        try {
            fileName("revathi.txt");
            System.out.println("file has elements");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void fileName(String name)
    {
    if(name==null || name.isEmpty())
    {
        throw new IllegalArgumentException("file is empty");
    }

    }
}
