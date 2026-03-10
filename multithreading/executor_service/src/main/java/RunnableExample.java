import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
for(int i=0;i<=5;i++) {
    Runnable task = () -> {
        System.out.println("Runnable task executed by " + Thread.currentThread().getName());
    };

    executor.submit(task);
}// Submit the Runnable task

        executor.shutdown();
    }
}