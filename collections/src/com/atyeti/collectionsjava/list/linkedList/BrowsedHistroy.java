package com.atyeti.collections.list.linkedList;
import java.util.LinkedList;

public class BrowsedHistroy {
    private LinkedList<String> hist = new LinkedList<>();
    private int cIndex = -1;

    public void visit(String url) {
        if (cIndex < hist.size() - 1) {

            while (hist.size() > cIndex + 1) {
                hist.removeLast();
            }
        }
        hist.add(url);
        cIndex++;
        System.out.println("visited: " + url);
    }

    public void back() {
        if (cIndex > 0) {
            cIndex--;
            System.out.println("back to: " + hist.get(cIndex));
        } else {
            System.out.println("we are in the first page.");
        }
    }

    public void forward() {
        if (cIndex < hist.size() - 1) {
            cIndex++;
            System.out.println("forward : " + hist.get(cIndex));
        } else {
            System.out.println(" we are in the latest page.");
        }
    }

    public static void main(String[] args) {
        BrowsedHistroy bh = new BrowsedHistroy();
        bh.visit("google.com");
         bh.visit("darwinbox.com");
        bh.visit("microsoft.com");
           bh.back();
        bh.back();
         bh.forward();
         bh.visit("github.com");
        bh.forward();
    }
}