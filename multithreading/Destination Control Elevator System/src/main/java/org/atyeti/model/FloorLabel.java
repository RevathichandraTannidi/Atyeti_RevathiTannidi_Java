package org.atyeti.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
@Getter@RequiredArgsConstructor
public enum FloorLabel {
    B2(-2, "B2"),
    B1(-1, "B1"),
    G(0, "G"),
    F1(1, "1"),
    F2(2, "2"),
    F3(3, "3"),
    F4(4, "4"),
    F5(5, "5"),
    F6(6, "6"),
    F7(7, "7"),
    F8(8, "8"),
    F9(9, "9"),
    F10(10, "10"),
    F11(11, "11"),
    F12(12, "12"),
    F13(13, "13"),
    F14(14, "14"),
    F15(15, "15");

    private final int number;
    private final String label;

    private static final Map<Integer, FloorLabel> map = new HashMap<>();

    static {
        for (FloorLabel f : FloorLabel.values()) {
            map.put(f.number, f);
        }
    }

    public static String getLabelByNumber(int num) {
        return map.get(num) != null ? map.get(num).getLabel() : String.valueOf(num);
    }

    public static boolean isValid(int num) {
        return map.containsKey(num);
    }
}

