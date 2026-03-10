package org.atyeti.java.concurrencyCounter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

    public class SynchronizedCounter {

        public static <T> Map<T, Long> count(Stream<T> stream) {
            Map<T, Long> map = new HashMap<>();

            stream.parallel().forEach(item -> {
                synchronized (map) {
                    map.put(item, map.getOrDefault(item, 0L) + 1);
                }
            });

            return map;
        }

        public static void main(String[] args) {
            System.out.println(count(Stream.of(3,4,5,4,3,2,4,5,6,7,5,2)));

        }


}
