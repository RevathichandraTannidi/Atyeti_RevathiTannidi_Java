package scrum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Arun {
    Arun() {
        print();
    }

    void print() {
        System.out.println("A");
    }
}

class Bob extends Arun {
    int x = 10;

    void print() {
        System.out.println(x);
    }
}
class book
{
    public static void main(String[] args) {
        new Bob();

        var list = new ArrayList<>(List.of(1,2,3));
        Stream<Integer> st = list.stream().map(x -> x * 2);
        list.add(4);
        System.out.println(st.collect(Collectors.toList()));

    }
}

