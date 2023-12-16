import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {

        String stringForList = "Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Tuesday,Wednesday,Thursday," +
                "Sunday,Monday,Tuesday,Friday,Wednesday,Wednesday,Thursday,Friday,Saturday,Friday,Friday";
        List<String> items = new ArrayList<>(Arrays.asList(stringForList.split(",")));
        String word1 = "Friday";
        String word2 = "Wednesday";

        System.out.println("Number of occurrence for " + word1 + ": " + countOccurrence(items, word1));
        System.out.println("Number of occurrence for " + word2 + ": " + countOccurrence(items, word2));

    }

    public static int countOccurrence(List<String> list, String word) {
        return Collections.frequency(list, word);
    }
}
