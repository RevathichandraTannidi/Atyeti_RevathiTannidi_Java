package operators;

import java.util.Scanner;

public class Matrix_operation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[][] A=new int[3][3];
        int[][] B=new int[3][3];
        int rows = A.length;
        int cols = A[0].length;
        int [][] sum = new int[3][3];
        int [][] sub= new int[3][3];
        int [][] multiply= new int[3][3];

        System.out.println("Enter the elements of Matrix A:");

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                A[i][j] = sc.nextInt();

            }
        }

        System.out.println("Enter the elements of Matrix B:");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                B[i][j]=sc.nextInt();
            }
        }

        System.out.println(" Matrix A:");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                System.out.print( A[i][j]+" ");
            }
            System.out.println(" ");
        }
        System.out.println(" Matrix B:");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                System.out.print( B[i][j]+" ");
            }
            System.out.println(" ");
        }


        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                sum[i][j]=A[i][j]+B[i][j];
            }
        }

        System.out.println("sum of the matrix resulted in Matrix sum:");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                System.out.print(sum[i][j]+" ");
            }
            System.out.println(" ");
        }

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                sub[i][j]=A[i][j] - B[i][j];
            }
        }

        System.out.println("subtraction of the matrix A nd B resulted in Matrix sub:");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                System.out.print(sub[i][j]+" ");
            }
            System.out.println(" ");
        }

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                multiply[i][j]=A[i][j]*B[i][j];
            }
        }

        System.out.println("multiply of the matrix A and B resulted in Matrix Multiply:");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                System.out.print(multiply[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}
