import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> task = () -> {
            return "Callable task executed by " + Thread.currentThread().getName();
        };

        Future<String> future = executor.submit(task);
        System.out.println(future.get());
        executor.shutdown();







    }
}