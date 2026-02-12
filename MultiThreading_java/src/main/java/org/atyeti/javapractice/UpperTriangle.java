package org.atyeti.javapractice;

public class UpperTriangle {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {0, 4, 5},
                {0, 0, 6}
        };

        int n = matrix.length;

        boolean isUpper = true;
        boolean isLower = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i > j && matrix[i][j] != 0) {
                    isUpper = false;
                }

                if (i < j && matrix[i][j] != 0) {
                    isLower = false;
                }
            }
        }

        if (isUpper) {
            System.out.println("Upper triangular matrix");
        } else if (isLower) {
            System.out.println("Lower triangular matrix");
        } else {
            System.out.println("No triangle pattern");
        }
    
    }
}
