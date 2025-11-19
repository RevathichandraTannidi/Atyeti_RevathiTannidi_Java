package org.atyeti.java.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class SeatStore {
    public static final int TOTAL_SEATS = 20;
    public static ConcurrentHashMap<Integer, String> bookedSeats = new ConcurrentHashMap<>();
    public static ReentrantLock LOCK = new ReentrantLock();

    }

