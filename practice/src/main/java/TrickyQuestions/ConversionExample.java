package TrickyQuestions;

import java.util.ArrayList;


    public class ConversionExample {
        public static void main(String[] args) {
            ArrayList<String> fruitsList = new ArrayList<>();
            fruitsList.add("Apple");
            fruitsList.add("Banana");
            fruitsList.add("Orange");

            // Convert ArrayList to an array
            String[] fruitsArray = fruitsList.toArray(new String[0]);

            // Now you can use fruitsArray as a standard array
            System.out.println("Array length: " + fruitsArray.length);
            System.out.println("First element of array: " + fruitsArray[0]);
        }
    }

