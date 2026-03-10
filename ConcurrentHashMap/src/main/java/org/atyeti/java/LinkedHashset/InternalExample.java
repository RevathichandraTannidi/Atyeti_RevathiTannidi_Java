package org.atyeti.java.LinkedHashset;

import java.util.LinkedHashSet;

public class InternalExample {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("A");  // hash=65  → bucket 1 (65 % 4 = 1)
        set.add("E");  // hash=69  → bucket 1 (69 % 4 = 1) ← COLLISION with "A"
        set.add("B");  // hash=66  → bucket 2 (66 % 4 = 2)
        set.add("F");  // hash=70  → bucket 2 (70 % 4 = 2) ← COLLISION with "B"
    }
}

/**
 * ┌──────────────────────────────────────────────────────────────────────┐
 * │ HASH TABLE (array of buckets)                                        │
 * │                                                                      │
 * │  Bucket 0:  null                                                     │
 * │                                                                      │
 * │  Bucket 1:  [Entry:"A"] → [Entry:"E"]                                │
 * │               ↑ next          ↑ next (null)                          │
 * │               │                                                       │
 * │  Bucket 2:  [Entry:"B"] → [Entry:"F"]                                │
 * │               ↑ next          ↑ next (null)                          │
 * │                                                                      │
 * │  Bucket 3:  null                                                     │
 * └──────────────────────────────────────────────────────────────────────┘
 *         ║           ║           ║           ║
 *         ║ (same Entry objects participate in BOTH structures) ║
 *         ║           ║           ║           ║
 * ┌───────╨───────────╨───────────╨───────────╨──────────────────────────┐
 * │ DOUBLY-LINKED LIST (insertion order)                                 │
 * │                                                                      │
 * │  head → [Entry:"A"] ↔ [Entry:"E"] ↔ [Entry:"B"] ↔ [Entry:"F"] ← tail │
 * │         ↑ before=null   ↑ before    ↑ before      ↑ before    ↑ after=null
 * │         ↑ after         ↑ after     ↑ after      ↑ after=null        │
 * └──────────────────────────────────────────────────────────────────────┘
 */