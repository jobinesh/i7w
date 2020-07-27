 class AA
{
    AA a = new AA();
}

class A
{
     int gg;
    void method(int i)
    {
        //method(int)
    }
}
class B extends A
{
    @Override
    void method(int i)
    {
        //method(Integer)
       int xx= super.gg;
    }
}
class CC
{
    static void staticMethod()
    {
        System.out.println("Static Method");
    }
    public void test(){
        staticMethod();
    }
}
public class IntegerDemo {
    public static void main(String[] args)
    {
       // AA ab= new AA();
        CC a = new CC();

        a.test();

        Integer i3 = 128;

        Integer i4 = 128;

        System.out.println(i3 == i4);

        Integer i1 = 127;

        Integer i2 = 127;

        System.out.println(i1 == i2);

    }
}
