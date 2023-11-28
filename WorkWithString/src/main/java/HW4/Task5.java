package HW4;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String str = scanner.nextLine();
        scanner.close();
        System.out.println("Is the string palindrome? - "+ isPalindrome(str.toLowerCase()));

    }

    public static boolean isPalindrome(String str) {
        StringBuilder output = new StringBuilder();

        boolean answer = false;

        for (int i = str.length() - 1; i >= 0; i--) {

            output.append(str.charAt(i));
        }
        if (str.contentEquals(output)) {
            answer = true;
        }
        return answer;
    }
}
