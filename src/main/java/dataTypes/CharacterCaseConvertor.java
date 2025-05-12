package dataTypes;

//Character Case Converter
//Take a char as input and convert:
//
//Uppercase to lowercase
//
//Lowercase to uppercase
public class CharacterCaseConvertor {
    public static void main(String[] args) {
        char a='q';
        char b='A';
        System.out.println("Lowercase to upper: " + Character.toUpperCase(a));
        System.out.println("Uppercase to lower: " + Character.toLowerCase(b));

    }
}
