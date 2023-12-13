import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        String[] stringArray = {"str1", "str2", "str3"};
        Integer[] intArray = {1, 3, 7, 6, 9, 8};
        Character [] charArray = {'a','d'};

        System.out.println(toList(stringArray));
        System.out.println(toList(intArray));
        System.out.println(toList(charArray));

    }
    public static <T> List<T> toList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
