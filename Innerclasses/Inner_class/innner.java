class out{
    public void show()
    {
        System.out.println("im the out ");
    }
    class in{
        public void show1()
        {
            System.out.println("im the IN");
        }
    }

    static class in1{
        public  void show1()
        {
            System.out.println("im the in-out");
        }
    }


}

public class innner {

    public static void main(String[] args) {
          out o=new out();
        o.show();

        out.in i=o.new in();
        i.show1();

        out.in1 i1=new out.in1();
        i1.show1();



    }

}
