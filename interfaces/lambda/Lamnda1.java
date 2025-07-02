
import java.util.*;

public class Lamnda1 {
    public static void main(String[] args) {

        List<String> name=Arrays.asList("revathi","kranthi","tanuja","sowmya","somii" ,"also" );
        Collections.sort(name,(e1,e2)->e1.compareTo(e2));
        name.forEach(e-> System.out.println(e));


        Collections.sort(name, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });


    }
}
