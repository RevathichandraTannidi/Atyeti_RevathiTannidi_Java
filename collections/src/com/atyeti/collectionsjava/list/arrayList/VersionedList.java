package com.atyeti.collections.list.arrayList;
//Clone current state for rollback/restore scenarios (e.g., form autosave or draft fea


import java.util.ArrayList;
import java.util.List;

class VersionedList<T> {
    private List<List<T>> history = new ArrayList<>();
    private List<T> current = new ArrayList<>();

    public void add(T value) {
        save();
        current.add(value);
    }

    public void save() {
        history.add(new ArrayList<>(current));
    }

    public void rollback(int version) {
        if (version < history.size()) {
            current = new ArrayList<>(history.get(version));
        }
    }

    public List<T> get() {
        return current;
    }

    public static void main(String[] args) {
        VersionedList<String> vList = new VersionedList<>();
        vList.add("a");
        vList.add("b");
        vList.save();
        vList.add("c");
        System.out.println("Before rollback: " + vList.get());
        vList.rollback(0);
        System.out.println("After rollback: " + vList.get());
    }
}

