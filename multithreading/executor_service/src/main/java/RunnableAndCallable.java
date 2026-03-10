import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableAndCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i <= 3; i++) {
            Runnable task=()->{
              System.out.println("hi im using runnable");
            };
            executor.submit(task);

        }


        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            int number = i;
            futures.add(executor.submit(() -> {
                return number * number;
            }));
        }


        for (Future<Integer> future : futures) {
            System.out.println("Callable result: " + future.get());
        }

        executor.shutdown();
    }
}
