package dataTypes;
//Hexadecimal to Decimal Converter
//Input: "1A" (as String)
//Output: 26 (as int)
//Avoid using Integer.parseInt.
public class HexaDecimalTodecimal {
    public static void main(String[] args) {
        String s="1A";
        int decimalValue = 0;
        int base = 1;
        int length = s.length();

        for (int i = length - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int digitValue;

            if (ch >= '0' && ch <= '9') {
                digitValue = ch - '0';
            } else if (ch >= 'A' && ch <= 'F') {
                digitValue = ch - 'A' + 10;
            } else {
                throw new IllegalArgumentException("Invalid hexadecimal character: " + ch);
            }
            decimalValue += digitValue * base;
            base *= 16;
        }
        System.out.println("Decimal value of hexadecimal " + s + " is: " + decimalValue);

    }
}
