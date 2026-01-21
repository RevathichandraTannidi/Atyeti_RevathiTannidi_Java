package streams.qwen;

import java.util.Arrays;
import java.util.List;

public class PrimeNumbers {

        public static boolean isPrime( int n){
            if (n < 2) return false;
            if (n == 2) return true;
            if (n % 2 == 0) return false;
            for (int i = 3; i * i <= n; i += 2) {
                if (n % i == 0) return false;
            }
            return true;
        }

        public static void main (String[]args){
            List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

            List<Integer> primes = numbers.stream()
                    .filter(PrimeNumbers::isPrime)
                    .toList(); // Java 16+

            System.out.println(primes); // [2, 3, 5, 7, 11]
        }
    }

