package dataTypes;
//Manual String to Integer Conversion
//Without using Integer.parseInt(), write a method to convert a numeric string (e.g., "1234") into an integer.
public class ManualStringToInt {
    public static void main(String[] args) {
        String s="1234";
        int num=0;
            int n=s.length();
            for(int i=0;i<n;i++)
            {
                 num= num*10+((int) s.charAt(i)-48);
            }
        System.out.println(num);



        System.out.println(0.1 + 0.2 == 0.3);// why false?
    }
}
