import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task3 {
    public static void main(String[] args) {
        List<Integer> list = List.of(2,3,4,5,43,4,3,2,1);

        System.out.println("Only unique values: "+findUnique(list));

    }
    public static Set<Integer> findUnique (List<Integer> list){
       return new HashSet<>(list);
    }
}
