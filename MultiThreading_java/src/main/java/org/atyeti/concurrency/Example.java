package org.atyeti.concurrency;

class Example {
     volatile boolean flag = false;

    void writer() {
        flag = true;
    }

    void reader() {
        while (!flag) {
        }
        System.out.println("Flag changed!");
    }

    public static void main(String[] args) {
        Example ex=new Example();
//ex.writer();
        ex.reader();
    }
}
