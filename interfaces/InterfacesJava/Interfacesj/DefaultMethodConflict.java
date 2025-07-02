package Interfacesj;
interface A
{
    default void hello(){
        System.out.println("hello Revathi");
    }

}
interface B
{
    default  void hello()
    {
        System.out.println("chandra");
    }
}
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
