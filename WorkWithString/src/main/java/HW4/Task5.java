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
        String rev = "";
        boolean answer = false;

        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        if (str.equals(rev)) {
            answer = true;
        }
        return answer;
    }
}
