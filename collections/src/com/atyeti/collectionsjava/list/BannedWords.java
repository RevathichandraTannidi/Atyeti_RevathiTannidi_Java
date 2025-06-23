package com.atyeti.collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class BannedWords {


    public static List<String> cleanChatLogs(List<String> chats,
                                             Set<String> bannedWords,
                                             int maxLen) {
        List<String> result = new ArrayList<>();
        ListIterator<String> it = chats.listIterator(chats.size());

        while (it.hasPrevious()) {
            String msg = it.previous();

            // Remove if contains any banned word
            String finalMsg = msg;
            boolean hasBanned = bannedWords.stream()
                    .anyMatch(b -> {
                        return finalMsg.toLowerCase().contains(b.toLowerCase());
                    });
            if (hasBanned) {
                it.remove();
                continue;
            }

            // Summarize if too long
            if (msg.length() > maxLen) {
                String summary = msg.substring(0, maxLen) + "...";
                it.set(summary);
                msg = summary;
            }

            result.add(msg);
        }
        return result;
    }



    public static void main(String[] args) {
        List<String> logs = new ArrayList<>(List.of(
                "Hello everyone",
                "This is definitely spam",
                "An extremely long message...that was nice to hear that only good thing is list iterator it has previous and forward iterations to do in the list iterator " +
                        "and we have split iterator also that we can split in two parts..",
                "All good!"
        ));
        Set<String> banned = Set.of("spam", "ad");

        List<String> cleaned = cleanChatLogs(logs, banned, 30);

        System.out.println(cleaned);
    }
}
