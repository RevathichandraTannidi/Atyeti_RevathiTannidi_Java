package collections;

import java.util.ArrayList;

public class ArrayList11 {
    public static void main(String[] args) {
        ArrayList<Integer> aa=new ArrayList<>();
        aa.add(10);
        aa.add(20);
        aa.add(30);
        aa.add(40);
        System.out.println(aa);
        aa.remove(Integer.valueOf(10));
        System.out.println(aa);
    }
}
