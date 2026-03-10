import java.util.concurrent.*;

public class ExecutorExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;

            Future<String> future = executor.submit(() -> {
                String message = "Task " + taskId + " executed by " + Thread.currentThread().getName();
                return message; // Callable returns a value
            });

            System.out.println("Result: " + future.get());
        }

        executor.shutdown();


        ExecutorService executor1 = Executors.newFixedThreadPool(3);
        executor1.submit(() -> System.out.println("Task executed"));
        executor1.shutdown();
    }
}
