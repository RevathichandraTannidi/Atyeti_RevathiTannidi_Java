public class AnonymousInnerClassDemo {
        public static void main(String[] args) {
            final String greet = "Hello";
            String name = "Revathi chandra";

            System.out.println("rc");

            Runnable greeter = new Runnable() {

                @Override
                public void run() {

                    System.out.println(greet + ", " + name + "!");
                }
            };
          //  name="raju"; it shows the error
            greeter.run();
        }
    }


