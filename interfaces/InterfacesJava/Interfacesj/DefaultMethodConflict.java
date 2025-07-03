package Interfacesj;

public class DefaultMethodConflict  implements A,B{
    @Override
    public void hello() {
        A.super.hello();
    }

    public static void main(String[] args) {
        DefaultMethodConflict dc=new DefaultMethodConflict();
        dc.hello();
    }
}
