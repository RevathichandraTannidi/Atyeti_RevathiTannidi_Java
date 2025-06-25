package com.atyeti.collections.set.eCommerece_project;

import java.util.concurrent.CopyOnWriteArraySet;

public class FeatureFlags {
    private final CopyOnWriteArraySet<String> flags = new CopyOnWriteArraySet<>();

    public void enable(String feature) {
        flags.add(feature);
    }

    public boolean isEnabled(String feature) {
        return flags.contains(feature);
    }
}
