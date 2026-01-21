package TrickyQuestions;

import java.util.HashMap;
import java.util.Map;

class A {
    static void display() {
        System.out.println("A");
    }
}
class B extends A {
    static void display() {
        System.out.println("B");
    }
}
public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("A", "1");
        map.put(new String("A"), "2");
        System.out.println(map);
        System.out.println(map.size());

    }

}
