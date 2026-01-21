package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Arraylis1 {
    public static void main(String[] args) {
        List<String> li =new ArrayList<>();
        li.add("reva");
        System.out.println(li);
        List list=new ArrayList<>();
        System.out.println(list.size());
        list.add(1);
        System.out.println(list.size());
        list.add(12);
        list.add(13);
        list.add(14);list.add(15);list.add(16);list.add(17);list.add(18);list.add(19);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list);

LinkedList<Integer> li1=new LinkedList<Integer>();
li1.add(1);
li1.addLast(2);
li1.add(1);
li1.addFirst(3);
        System.out.println(li1);

    }
}
