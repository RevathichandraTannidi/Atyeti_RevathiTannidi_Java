package oops.oopsGFG;

import java.util.Scanner;

public class SeriesCalculator {
    public static void main(String[] args) {
//Create a class SeriesCalculator with a method calculateSum(int n) to calculate the
// sum of the first n numbers in the series 1 + 3 + 5 + 7 + .... Use the formula
// Sum = (n/2) * [2*a + (n-1)*d],
// where "a" is the first term and "d" is the common difference.

        Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
        SeriesCalculator s=new SeriesCalculator();
        System.out.println(  s.sum(n));

    }
    public int sum(int n)
    {
        int a=1;
        int d=2;
                return (n * (2 * a + (n - 1) * d)) / 2;
    }
}

