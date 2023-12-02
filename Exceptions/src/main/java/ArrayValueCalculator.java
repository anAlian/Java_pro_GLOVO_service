
import java.util.Scanner;

public class ArrayValueCalculator {
    public static void main(String args[]) throws ArrayDataException, ArraySizeException {

        Scanner scr = new Scanner(System.in);
        int n = 4;
        String[][] arr = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scr.nextLine();
            }
        }
        scr.close();
        printArray(arr, n);
        System.out.println("Sum of array elements: " + doCalc(arr));
    }

    public static void printArray(String[][] arr, int n) {
        System.out.println("Your array: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int doCalc(String[][] array) throws ArrayDataException, ArraySizeException {
        int result = 0;
        int n = 4;
        int[][] matrix = new int[n][n];
        try {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    try {
                        matrix[i][j] = Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new ArrayDataException("Error element has index: " + i + ", " + j, e);
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArraySizeException("Array size should be " + n + "x" + n, e);
        } finally {
            for (int[] arr : matrix)
                for (int i : arr)
                    result += i;
        }
        return result;
    }
}

