package com.atyeti.collections.list.arrayList;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
public class Copyonwrite {
    public static void main(String[] args) {

      CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();
       list1.add("Apple");
        list1.add("Banana");
        System.out.println("default Constructor: " + list1);

        List<String> sourceList = Arrays.asList("X", "Y", "Z");
           CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<>(sourceList);
         System.out.println("\nconstructor from Collection: " + list2);

        CopyOnWriteArrayList<String> list3 = new CopyOnWriteArrayList<>(list2);
           System.out.println(" CopyOnWriteArrayList: " + list3);

        list1.add("Cherry");
        System.out.println("\n  add(): " + list1);

        list1.add(1, "Orange");
            System.out.println(" after add(): " + list1);
        list1.addAll(Arrays.asList("Grape", "Mango"));
          System.out.println(" addAll : " + list1);

        list1.addAll(2, Arrays.asList("Pineapple", "Kiwi"));
            System.out.println("  addAll(): " + list1);

        list1.remove("Banana");
        System.out.println("\n remove(): " + list1);

        list1.remove(0);
           System.out.println(" remove: " + list1);

        list1.set(1, "Blueberry");
           System.out.println("set: " + list1);
        System.out.println("\n get(2): " + list1.get(2));

          System.out.println("size(): " + list1.size());
        System.out.println(" isEmpty(): " + list1.isEmpty());

        System.out.println(" contains: " + list1.contains("Cherry"));
    System.out.println("indexOf: " + list1.indexOf("Cherry"));
          System.out.println("  lastIndexOf: " + list1.lastIndexOf("Cherry"));

         Object[] arr = list1.toArray();
           System.out.println(" toArray(): " + Arrays.toString(arr));

         String[] strArr = list1.toArray(new String[0]);
        System.out.println(" toArray(String[]): " + Arrays.toString(strArr));

        CopyOnWriteArrayList<String> temp = new CopyOnWriteArrayList<>(list1);
          temp.clear();
         System.out.println(" clear: " + temp);

        CopyOnWriteArrayList<String> list4 = new CopyOnWriteArrayList<>(Arrays.asList("A", "B", "C"));
           list4.retainAll(Arrays.asList("B", "C", "D"));
        System.out.println("retainAll: " + list4);

            CopyOnWriteArrayList<String> list5 = new CopyOnWriteArrayList<>(Arrays.asList("A", "B", "C", "D"));
        list5.removeAll(Arrays.asList("B", "D"));
        System.out.println("removeAll :" + list5);

        System.out.println("containsAll :" + list5.containsAll(Arrays.asList("A", "C")));

    System.out.println("stream filter:");
        list1.stream().filter(s -> s.startsWith("P")).forEach(System.out::println);
           System.out.println("\n using Iterator:");
    Iterator<String> iterator = list1.iterator();
    while (iterator.hasNext()) {
        String val = iterator.next();
        if (val.equals("Cherry")) {
            iterator.remove();
        }
    }
    System.out.println(" Iterator.remove(): " + list1);

    System.out.println("ListIterator:");
      ListIterator<String> listIterator = list1.listIterator();
    while (listIterator.hasNext()) {
        System.out.print(listIterator.next() + " ");
        }
        System.out.println("\n  Backward:");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }

    System.out.println("\nsubList(1, 4): " + list1.subList(1, 4));

       CopyOnWriteArrayList<String> list6 = new CopyOnWriteArrayList<>(list1);
      System.out.println("equals(copy): " + list1.equals(list6));
    System.out.println("hashCode(): " + list1.hashCode());
       System.out.println("toString(): " + list1);

      Spliterator<String> spliterator = list1.spliterator();
    System.out.println("Spliterator characteristics: " + spliterator.characteristics());
        }
    }
