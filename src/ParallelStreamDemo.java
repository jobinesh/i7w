import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ParallelStreamDemo {
    public ParallelStreamDemo() {
    }
    public static void main(String[] arg){
        new ParallelStreamDemo().test();
    }
    public void test(){
        List list = Arrays.asList(10, 320, 30);
        Stream stream= list.parallelStream();
        Optional<Integer> max= stream.max(Comparator.naturalOrder());
        System.out.println("max :: "+ max.get());
    }
}
