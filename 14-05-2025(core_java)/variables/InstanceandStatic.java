public class InstanceandStatic {
    static int x=20;
    public static void main(String[] args) {
        int x=10;
        x=20;
        InstanceandStatic.x=30;
        System.out.println(x);// local variable
        System.out.println(InstanceandStatic.x);//static variable

    }
}
// here all the static and instance are modified