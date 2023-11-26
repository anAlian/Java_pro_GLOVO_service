package HW4;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Source string: ");
        String source = scanner.nextLine();
        System.out.println("Enter the Target string: ");
        String target = scanner.nextLine();
        findWordPosition(source,target);
        scanner.close();
    }

    public static void findWordPosition (String sr,String tg){
        System.out.println("Index of the first element: "+ sr.indexOf(tg));
    }
}
