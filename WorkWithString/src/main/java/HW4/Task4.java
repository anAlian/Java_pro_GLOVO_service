package HW4;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String textRev = scanner.nextLine();
        scanner.close();

        System.out.println("Reverse string: " + stringReverse(textRev));
    }

    public static String stringReverse (String input) {

        StringBuilder output = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            output.append(input.charAt(i));
        }

        return output.toString();
    }
}
