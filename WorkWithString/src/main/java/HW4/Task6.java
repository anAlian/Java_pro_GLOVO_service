package HW4;

import java.util.Random;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
                "potato"};

        String compWord;
        String userWord;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        do {
            int number = random.nextInt(words.length);

            System.out.println("computer word: " + words[number]); //for test
            compWord = words[number];

            System.out.println("Guess the word: ");
            userWord = scanner.nextLine();


          compareStrings(compWord,userWord);

        } while (!(compWord.equals(userWord)));
        scanner.close();

    }
    public static void compareStrings (String str1, String str2) {

        if (str1.equals(str2)){
            System.out.println("Congrats!");
        } else {
            addAster(str1,str2);
            System.out.println("Try again!");}
    }
    public static void addAster (String str1, String str2){

        StringBuilder output = new StringBuilder();
        for (int i = 0, j = 0; i < str1.length() && j < str2.length(); i++, j++) {
            if (str1.charAt(i) == str2.charAt(j)) {
                output.append(str1.charAt(i));

            } else output.append("*");

        } output.append("*".repeat(15 - output.length()));

        System.out.println(output);
    }
}
