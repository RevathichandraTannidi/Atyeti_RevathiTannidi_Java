package com.atyeti.collections.mapcollection;

import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;

public class UserLogin {

    private final Map<String, Integer> loginCounts = new HashMap<>();

    public void recordLogin(String username) {
        loginCounts.put(username, loginCounts.getOrDefault(username, 0) + 1);
    }


    public int getLoginCount(String username) {
        return loginCounts.getOrDefault(username, 0);
    }


    public List<String> getTopNUsers(int n) {
        return loginCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
                .limit(n).map(Map.Entry::getKey).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        UserLogin tracker = new UserLogin();

     tracker.recordLogin("Revathi ");
        tracker.recordLogin("chandra");
         tracker.recordLogin("kranthi");
         tracker.recordLogin("Revathi");
          tracker.recordLogin("chandra");
        tracker.recordLogin("Revathi");

         System.out.println("Revathi login count: " + tracker.getLoginCount("Revathi"));
        System.out.println("Top 2 users: " + tracker.getTopNUsers(2));
    }

}


//question
//User Login Frequency Counter
//Scenario:
//You're building a system to monitor how many times users log into your app.
// You need to store login counts per user and be able to retrieve the top N most
// active users.
//Requirements:
//Use a Map<String, Integer> where key is username.
//Implement methods:
//void recordLogin(String username)
//int getLoginCount(String username)
//List<String> getTopNUsers(int n)