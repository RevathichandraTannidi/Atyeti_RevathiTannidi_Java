package com.atyeti.collections.set;

import java.util.*;

public class RecentSearchTerms {
    private static final int MAX_SIZE = 3;
    private LinkedHashSet<String> searches = new LinkedHashSet<>();

    public void addSearch(String term) {
        if (searches.contains(term)) {
            searches.remove(term);
        }
        if (searches.size() == MAX_SIZE) {
            Iterator<String> it = searches.iterator();
            it.next();
            it.remove();
        }
        searches.add(term);
    }

    public void printTerms() {
        System.out.println("recent searches: " + searches);
    }

    public static void main(String[] args) {
        RecentSearchTerms rs = new RecentSearchTerms();
        rs.addSearch("java");
        rs.addSearch("spring");
        rs.addSearch("set");
        rs.addSearch("spring");
        rs.addSearch("streams");

        rs.printTerms();
    }
}
