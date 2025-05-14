public class Variableshawdowing {
    public static void main(String[] args) {
Variableshawdowing vs=new Variableshawdowing();
       vs.outerMethod();
        System.out.println("\n");
       vs.innerMethod();
    }
    void outerMethod()
    {
        int x=10;
        System.out.println("the outer x:"+x);
        innerMethod();
    }
    void innerMethod()
    {
        int x=20;
        System.out.println("The inner x:"+x);
    }
}


//Variable Shadowing:
//Occurs when a local variable or parameter has the same name as an instance variable.
//  The local variable "shadows" the instance variable within its scope.