package org.atyeti.javapractice;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public static void main(String[] args) {
        int[] num = {1, 2, 4, 5};
        int missing=findMissing(num);
        System.out.println(missing);
    }
public static int findMissing(int[] nums){
            Set<Integer> set = new HashSet<>();
            for (int x : nums)
                set.add(x);

            for (int i = 1; i <= nums.length+1; i++) {
                if (!set.contains(i))
                    return i;
            }
    throw new IllegalArgumentException("Input array is not in the expected 1..N format.");
}

}
