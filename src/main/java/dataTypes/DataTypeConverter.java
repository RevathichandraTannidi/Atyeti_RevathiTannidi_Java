package dataTypes;

public class DataTypeConverter {

    public static Integer stringToInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("invalid integer format: " + str);
            return null;
        }
    }

    public static String integerToString(Integer value) {
        if (value != null) {
            return value.toString();
        } else {
            System.out.println("null value provided.");
            return null;
        }
    }

    public static String doubleToString(Double value) {
        if (value != null) {
            return value.toString();
        } else {
            System.out.println("Null value provided.");
            return null;
        }
    }

    public static Double stringToDouble(String str) {
try{ return Double.parseDouble(str);
} catch (NumberFormatException e) {
System.out.println("Invalid double format: " + str);
return null;
}
    }


            public static Double integerToDouble(Integer value) {
        if (value != null) {
            return value.doubleValue();
        } else {
            System.out.println("Null value provided.");
            return null;
        }
    }

    // Method to convert Double to Integer
    public static Integer doubleToInteger(Double value) {
        if (value != null) {
            return value.intValue();
        } else {
            System.out.println("Null value provided.");
            return null;
        }
    }

    public static void main(String[] args) {
        // Example usage
        String strInt = "123";
        String strDouble = "123.45";
        Integer intValue = 456;
        Double doubleValue = 789.01;

        System.out.println("String to Integer: " + stringToInteger(strInt));
        System.out.println("String to Double: " + stringToDouble(strDouble));
        System.out.println("Integer to String: " + integerToString(intValue));
        System.out.println("Double to String: " + doubleToString(doubleValue));
        System.out.println("Integer to Double: " + integerToDouble(intValue));
        System.out.println("Double to Integer: " + doubleToInteger(doubleValue));

        // Handling invalid input
        System.out.println("Invalid String to Integer: " + stringToInteger("abc"));
        System.out.println("Invalid String to Double: " + stringToDouble("abc"));
    }


}

