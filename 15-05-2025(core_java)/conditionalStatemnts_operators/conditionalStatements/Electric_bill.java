package conditionalStatements;

import java.util.Scanner;

public class Electric_bill
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the units of the Electric bill:");
        int units=sc.nextInt();


double bill = 0;
 if (units <= 50) {
     bill = units * 0.50;
 }
 else if (units <= 200) {
bill = 50 * 0.50 + (units - 50) * 0.75;
 }
 else if (units <= 450)
 {
 bill = 50 * 0.50 + 150 * 0.75 + (units - 200) * 1.20;
}
 else {
bill = 50 * 0.50 + 150 * 0.75 + 250 * 1.20 + (units - 450) * 1.50;
 }
 double surcharge = bill * 0.20;
double totalBill = bill + surcharge;
System.out.println("THE TOTAL bill:"+totalBill);
    }
}
