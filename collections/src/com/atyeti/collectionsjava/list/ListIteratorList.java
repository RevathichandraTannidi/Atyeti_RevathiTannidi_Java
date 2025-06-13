package com.atyeti.collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorList {

    public static List<String> filterRecentMessages(List<String> chats, int minLength) {
        List<String> result = new ArrayList<>();
        ListIterator<String> it = chats.listIterator(chats.size());

        while (it.hasPrevious()) {
            String msg = it.previous();
            if (msg.length() >= minLength) {
                result.add(msg);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> msgs = List.of(
                "Hi",
                "This is a test message",
                "OK","Tested",
                "Another valid one"
        );
        List<String> filtered = filterRecentMessages(msgs, 5);
        System.out.println(filtered);


    }
}
