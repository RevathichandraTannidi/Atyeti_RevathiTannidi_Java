package dataTypes;
//ASCII Sum of a String
//Read a string input and compute the sum of ASCII values of all characters.
public class ASCII_sum_of_String {
    public static void main(String[] args) {
        String str="Revathi chandra";
        int sum=0;
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            sum+=ch;
        }
        System.out.println("The sum of ASCII values "+sum);
    }
}
