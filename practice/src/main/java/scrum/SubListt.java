package scrum;

import java.util.ArrayList;
import java.util.List;

public class SubListt {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(5,6,7,4));
        List<Integer> sub = list.subList(1, 3);
      //  list.add(5);

        System.out.println(sub);

    }
}
