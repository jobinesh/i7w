 class BaseDemo1 {
    final String test="";
    /* BaseDemo1(){
        this("jj");
        System.out.println("BaseDemo1");

    }*/
    BaseDemo1(String arg){
        System.out.println("BaseDemo1 :"+arg);
    }
    static  void test()throws Exception  {

    }


     public static void function(int it){

         System.out.println("method with param type – int: "+ it);

     }

}
class MyEx extends Exception{

}
public class ConstructorDemo extends BaseDemo1 {

    public static void function(Integer It){

        System.out.println("method with param type – Integer: "+It);

    }
    public ConstructorDemo(String arg){
        super("arg1");
        System.out.println("ConstructorDemo");
    }
    static void test(){

    }
    public static void main(String[] arg){
        ConstructorDemo demo = new ConstructorDemo("test");
        test();
        function(10);
        boolean isTrue = false;
        if(isTrue=true){ System.out.println("TRUE");//Will be printed.
        }

    }
}
