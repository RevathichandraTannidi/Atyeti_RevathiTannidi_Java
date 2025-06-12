package com.atyeti.collections.list.arrayList;

import java.util.ArrayList;

public class BulkAllocation {
    public static void main(String[] args) {

        int logcount=1_000_000;
        ArrayList<String> ac=new ArrayList<>();
        ac.ensureCapacity(logcount);   // ensure capacity it resizing the capacity 	Prevents resizing during future adds
        for(int i=0;i<logcount;i++)
        {
            ac.add("entry"+i);
        }
ac.trimToSize();

        System.out.println("total logs :"+ac.size());

    }
}



/*  You are designing a logging system that stores 1 million logs in an ArrayList.
Task:
Prevent internal resizing overhead during insertions.
Ensure that memory usage is optimized after insertion ends.
Expected Usage:
ensureCapacity() before adding, and trimToSize() after processing.  */