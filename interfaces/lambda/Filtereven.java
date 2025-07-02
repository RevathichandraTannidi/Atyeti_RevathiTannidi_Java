
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filtereven {
    public static void main(String[] args) {
        List<Integer> li= Arrays.asList(2,4,5,7,8,123);
        List<Integer> even=li.stream().filter(x->x%2==0).collect(Collectors.toList());
        System.out.println(even);
    }
}
