package Exception;

public class Main2 {
    public static void main(String[] args) {

        System.out.println( method1());
        System.out.println();
    }

    public static int method1() {
        int x = 10;
        try {
            return x;
        } finally {
            x = 20;
       // return x;     if we return in finally it will execute the 20 otherwise x-10.
        }


        }
    }
