package ch.yvesbeutler.sorting;

/**
 * @author yvesbeutler
 * @since 04.03.2016
 * This example shows how to sort an array of numbers with the bubble sort algorithm
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] input = {4, 2, 9, 6, 23, 12, 34, 0, 1};

        // bubble sort
        for (int n = input.length; n > 1; n--) {
            boolean hasChanged = false;
            for (int i = 0; i < n - 1; i++) {
                if (input[i] > input[i+1]) {
                    hasChanged = true;
                    swap(i, input);
                }
            }
            if (!hasChanged) {
                break;
            }
            print(input);
        }
    }

    private static void swap(int i, int[] array) {
        int temp = array[i];
        array[i] = array[i+1];
        array[i+1] = temp;
    }

    private static void print(int[] array) {
        for (int number : array) {
            System.out.print(number + ", ");
        }
        System.out.println();
    }

}
