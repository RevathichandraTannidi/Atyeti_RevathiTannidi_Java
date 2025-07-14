package org.atyeti.locks_synchronized.reentrantLock;

public class NEstedMain {
    public static void main(String[] args) {
        NestedLock Nl=new NestedLock();
        Nl.inner();
        Nl.outer();
    }
}
