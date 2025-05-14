package dataTypes.nonPrimitive;

import java.util.ArrayList;
import java.util.List;

// Handling multiple items, such as a list of user inputs or search results.
public class ManagingCollection {
    public static void main(String[] args) {
        List<String> user=new ArrayList<>();
        user.add("revathi chandra");
        user.add("someswari");
        user.add("chandu");
        user.add("Tannidi");
        for(String s:user)
        {
            System.out.println(s);
        }
    }
}
