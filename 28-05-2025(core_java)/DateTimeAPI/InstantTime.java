

import java.time.Duration;
import java.time.Instant;

public class InstantTime {
    public static void main(String[] args) {
        Instant currentInstant = Instant.now();
        System.out.println("Current Instant: " + currentInstant);
        Instant futureInstant = currentInstant.plus(Duration.ofSeconds(60));
        System.out.println("Instant after 60 seconds: " + futureInstant);

    }
}
