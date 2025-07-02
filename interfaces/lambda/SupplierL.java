

import java.util.function.Supplier;

public class SupplierL {
    public static void main(String[] args) {
        Supplier<String> s=() ->"hello world";
        System.out.println(s.get());
    }}
