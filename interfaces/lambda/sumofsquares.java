
import java.util.Arrays;
import java.util.List;

public class sumofsquares {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        int sumOfSquares = nums.stream()
                .map(x -> x * x)
                .reduce(0, Integer::sum);
        System.out.println(sumOfSquares);
    }
}
