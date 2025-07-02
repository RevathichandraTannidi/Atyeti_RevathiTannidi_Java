
import java.util.Arrays;
import java.util.OptionalInt;

public class Countnum {
    public static void main(String[] args) {
        int [] a ={1,2,3,5,6,6};
        System.out.println(Arrays.stream(a).sum());

    }
}
//int sumOfSquares = nums.stream()
//        .map(x -> x * x)
//        .reduce(0, Integer::sum);
////        System.out.println(sumOfSquares);