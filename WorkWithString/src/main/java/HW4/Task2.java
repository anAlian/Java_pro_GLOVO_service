package HW4;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String str = scanner.nextLine();
        System.out.println("Enter a symbol: ");
        char ch = scanner.next().charAt(0);

        scanner.close();
        System.out.println("Number of occurrence of Symbol "+ch +" in String "+ str + " is: "+ findSymbolOccurrence(str,ch));


    }
    public static int findSymbolOccurrence(String str, char ch){
        int countOc = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                countOc++;
            }
    }
        return countOc;
    }

}
