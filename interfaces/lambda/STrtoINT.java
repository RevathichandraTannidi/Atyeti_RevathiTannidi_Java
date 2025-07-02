package lambda;

import java.sql.SQLOutput;
import java.util.function.Function;

public class STrtoINT {
    public static void main(String[] args) {
        //Write a lambda function using Function<String, Integer>
        // that converts a string to an integer.
        Function<String,Integer> fl = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return 0;
            }
        };
        Function<String,Integer> f = (s)->s.compareTo("jj");
        Function<String,Integer> ftt = s-> s.indexOf("") ;

        System.out.println( fl.apply("jj"));
        System.out.println(  f.apply("JJ"));
        System.out.println(  ftt.apply(""));
        Function<String,Integer> flj= s->Integer.parseInt(s);
        System.out.println(flj.apply("1235"));

        Function<Integer,String> ft=s->String.valueOf(s);
        System.out.println(ft.apply(2345));


    }
}
