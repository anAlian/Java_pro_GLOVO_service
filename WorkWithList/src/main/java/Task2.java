import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        String[] stringArray = {"str1", "str2", "str3"};
        Integer[] intArray = {1, 3, 7, 6, 9, 8};
        Character [] charArray = {'a','d'};

        System.out.println(fromArrayToList(stringArray));
        System.out.println(fromArrayToList(intArray));
        System.out.println(fromArrayToList(charArray));

    }
    public static <T> List<T> fromArrayToList(T[] a) {
        return new ArrayList<>(Arrays.asList(a));
    }
}
