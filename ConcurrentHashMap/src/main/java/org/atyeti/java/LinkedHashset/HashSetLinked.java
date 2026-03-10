//package org.atyeti.java.LinkedHashset;
//
//import java.util.HashMap;
//
//public class HashSetLinked {
//    public class LinkedHashSet<E> extends HashSet<E> implements Set<E> {
//
//        // Backing map
//        private transient LinkedHashMap<E, Object> map;
//
//        // Dummy value for all entries
//        private static final Object PRESENT = new Object<>();
//
//        public LinkedHashSet() {
//            super(16, .75f, true); // Calls HashSet's package-private constructor
//        }
//
//        // Inherited from HashSet (package-private constructor):
//        HashSet(int initialCapacity, float loadFactor, boolean dummy) {
//            map = new LinkedHashMap<>(initialCapacity, loadFactor);
//        }
//
//        // All operations delegate to LinkedHashMap
//        public boolean add(E e) {
//            return map.put(e, PRESENT) == null;
//        }
//
//        public boolean remove(Object o) {
//            return map.remove(o) == PRESENT;
//        }
//    }
//
//    class LinkedHashMap<K,V> extends HashMap<K,V> {
//        static class Entry<K,V> extends HashMap.Node<K,V> {
//            Entry<K,V> before, after;
//            Entry(int hash, K key, V value, Node<K,V> next) {
//                super(hash, key, value, next)  nbnbnb        ;
//            }
//        }
//
//        transient Entry<K,V> head;
//        transient Entry<K,V> tail;
//
//        void linkNodeLast(Entry<K,V> p) {
//            Entry<K,V> last = tail;
//            tail = p;
//            if (last == null)
//                head = p;
//            else {
//                p.before = last;
//                last.after = p;
//            }
//        }
//
//        // Doubly-linked list head/tail (fields in LinkedHashMap)
//        transient LinkedHashMap.Entry<K,V> head;  // Oldest insertion
//        transient LinkedHashMap.Entry<K,V> tail;  // Newest insertion
//
//        // Entry structure (extends HashMap.Node)
//        static class Entry<K,V> extends HashMap.Node<K,V> {
//            Entry<K,V> before, after;  // ← Order-maintaining links
//            Entry(int hash, K key, V value, Node<K,V> next) {
//                super(hash, key, value, next);  // ← 'next' from HashMap.Node
//            }
//        }
//
//        // HashMap.Node (parent class)
//        static class Node<K,V> implements Map.Entry<K,V> {
//            final int hash;    // ← Cached hash code
//            final K key;       // ← Your element (in LinkedHashSet)
//            V value;           // ← Dummy PRESENT object
//            Node<K,V> next;    // ← Collision chain within bucket
//        }
//}
