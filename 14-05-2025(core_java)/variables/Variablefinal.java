public class Variablefinal {
    public static void main(String[] args) {
       final int x=1;

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Runnable runnable = () -> {

                     System.out.println("Iteration " + finalI + ": finalVariable " + x);
                 };
                 runnable.run();

        }

    }
}
//java: cannot assign a value to final variable i here is the error while running the program
