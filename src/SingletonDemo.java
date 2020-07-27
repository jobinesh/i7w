import java.io.Serializable;

public class SingletonDemo implements Serializable {
    private static SingletonDemo INSTANCE;
    private SingletonDemo(){

    }
    public static SingletonDemo getInstance(){
        if(INSTANCE == null){
            synchronized(SingletonDemo.class) {
                if(INSTANCE == null) {
                    INSTANCE = new SingletonDemo();
                }
            }
        }
        return INSTANCE;
    }

    public Object readResolve(){
        return INSTANCE;
    }

    public static void main(String[] arg){
        SingletonDemo singletonDemo = SingletonDemo.getInstance();
    }

}
