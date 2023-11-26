package HW4;

import java.util.Random;

public class Task6 {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado" , "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
                "potato"};
        Random random = new Random();
        int number = random.nextInt(10);
        assertThat(number).isPositive().isLessThan(10);
    }
}
