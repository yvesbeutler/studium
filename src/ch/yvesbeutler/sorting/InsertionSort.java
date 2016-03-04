package ch.yvesbeutler.sorting;

/**
 * @author yvesbeutler
 * @since 04.03.2016
 * This example shows how to sort an array of numbers with the insertion sort algorithm
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] input = {4, 2, 9, 6, 23, 12, 34, 0, 1};
        int temp;

        // insertion sort
        for (int i = 1; i < input.length; i++) {
            temp = input[i];
            int j = i;
            while (j > 0 && input[j-1] > temp) {
                input[j] = input[j-1];
                j--;
            }
            input[j] = temp;
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
