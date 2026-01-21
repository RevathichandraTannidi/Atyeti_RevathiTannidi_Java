package scrum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Boxing {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6};
        List<Integer> s= Arrays.stream(a).filter(x->x%2==0).mapToObj(Integer::valueOf).collect(Collectors.toList());
        System.out.println(s);
    }
}
