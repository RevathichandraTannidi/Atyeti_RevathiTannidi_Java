package streams.qwen;

import java.util.Arrays;
import java.util.Comparator;

public class StrngLength {
    public static void main(String[] args) {
        String s=" Atchyuth revathi chandra";
        String[] s1=s.split(" ");
        String ss=Arrays.stream(s.split(" ")).max(Comparator.comparing(String::length)).orElse("");
        long s2= Arrays.stream(s1).max(Comparator.comparing(String::length)).orElse("").length();
        String s3= Arrays.stream(s1).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get();
        System.out.println("Highest string :"+ss);
        System.out.println("second highest string: "+s3);
        System.out.println("Highest string length: "+s2);

    }
}
