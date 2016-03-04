package ch.yvesbeutler.sorting;

/**
 * @author yvesbeutler
 * This example shows how to sort an array of numbers with the selection sort algorithm
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] input = {4, 2, 9, 6, 23, 12, 34, 0, 1};

        // selection sort
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] > input[j]) {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
            print(input);
        }
    }

    private static void print(int[] array) {
        for (int number : array) {
            System.out.print(number + ", ");
        }
        System.out.println();
    }

}
