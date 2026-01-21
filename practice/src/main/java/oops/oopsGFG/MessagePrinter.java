package oops.oopsGFG;

import java.util.Scanner;

// Create a class MessagePrinter with a method printMessage(String name)
// which prints the message "hello <name>".
public class MessagePrinter {
    public void printMessage(String name)
    {
        System.out.println("Hello "+name);
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the name :");
        String name= s.nextLine();
      MessagePrinter m= new MessagePrinter();
      m.printMessage(name);
    }
}
