
import java.time.LocalDateTime;

public class PlusAndMinus {
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime futureDateTime = currentDateTime.plusDays(5).plusHours(3);
        LocalDateTime pastDateTime = currentDateTime.minusWeeks(2).minusMinutes(30);

        System.out.println("Current Date and Time: " + currentDateTime);
        System.out.println("Future Date and Time: " + futureDateTime);
        System.out.println("Past Date and Time: " + pastDateTime);
    }
}
