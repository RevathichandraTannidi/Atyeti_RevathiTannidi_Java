package dataTypes;


import java.math.BigDecimal;

public class PrecisionLossDemo {

    public static void main(String[] args) {
        // precision loss between float and double
        float floatValue = 1.1234567f;
        double doubleValueFromFloat = (double) floatValue;

        System.out.println("Original float value: " + floatValue);
        System.out.println("Converted to double: " + doubleValueFromFloat);

        double doubleValue = 1.1234567890123456789;
        BigDecimal bigDecimalFromDouble = BigDecimal.valueOf(doubleValue);

        System.out.println("Original double value: " + doubleValue);
        System.out.println("Converted to BigDecimal: " + bigDecimalFromDouble);

        // precision with BigDecimal
        BigDecimal preciseBigDecimal = new BigDecimal("1.1234567890123456789");

        System.out.println("Precise BigDecimal value: " + preciseBigDecimal);
    }
}
