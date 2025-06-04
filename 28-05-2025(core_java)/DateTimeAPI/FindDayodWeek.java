

import java.time.DayOfWeek;
import java.time.LocalDate;

public class FindDayodWeek {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2025, 9, 23);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println(date.lengthOfYear());
        System.out.println("Day of the Week: " + dayOfWeek);

        int i,j,k,l=0;
        k = l++;
        System.out.println(k);
        j = ++k;
        System.out.println(j);
        i = j++;
        System.out.println(i);

    }
}
