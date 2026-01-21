package TrickyQuestions;

import java.util.ArrayList;
import java.util.Arrays;

class Main {
    public static void main (String[] args) {

        // Creating an ArrayList
        ArrayList<Integer[]> a = new ArrayList<Integer[]>();

        // Adding Element in ArrayList
        a.add(new Integer[]{1,2,3});
        a.add(new Integer[]{3,4,1});
        a.add(new Integer[]{4,5,2});

        // Printing ArrayList
        System.out.println(Arrays.deepToString(a.toArray()));
    }
}
