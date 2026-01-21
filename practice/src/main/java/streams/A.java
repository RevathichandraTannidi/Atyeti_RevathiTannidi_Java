package streams;


interface A {
    default void show() {
        System.out.println("A");
    }
}

interface B {
    default void show() {
        System.out.println("B");
    }
}

class C implements  B,A {
    public void show() {
        B.super.show(); // resolve conflict
    }



    public static void main(String[] args) {
        C c=new C();
        c.show();
    }


//    @Override
//    public void show() {
//        A.super.show();
//    }



}
