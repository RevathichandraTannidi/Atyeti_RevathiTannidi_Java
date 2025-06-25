package com.atyeti.collections.set.eCommerece_project;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class SearchHistory {
    private final LinkedHashSet<String> searches = new LinkedHashSet<>();
    private final int MAX = 5;

    public void search(String term) {
        if (searches.contains(term)) searches.remove(term);
        if (searches.size() == MAX) {
            Iterator<String> it = searches.iterator();
            it.next();
            it.remove();
        }
        searches.add(term);
    }

    public void showHistory() {
        System.out.println("Recent Searches: " + searches);
    }
}
