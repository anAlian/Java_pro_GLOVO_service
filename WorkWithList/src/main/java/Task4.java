import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        String stringForList = "Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Tuesday,Wednesday,Thursday,Sunday,Monday,Tuesday,Friday,Wednesday,Wednesday,Thursday,Friday,Saturday,Friday,Friday";
        List<String> list = new ArrayList<>(Arrays.asList(stringForList.split(",")));
        findOccurrence(list);

    }

    public static void findOccurrence(List<String> list) {
        Set<String> set = new HashSet<>(list);

        for (String s : set) {

            System.out.println(s + ", occurrence : " + Collections.frequency(list, s));
        }
    }
}
