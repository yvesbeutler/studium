package ch.yvesbeutler.recursion;

import java.util.Arrays;

/**
 * @author yvesbeutler
 * @since 04.03.2016
 * This class uses divide & conquer to find a certain number in an array.
 */
public class FindNumberInArray {

    private static int NUMBER = 4;
    private static int[] ARRAY = {1, 3, 6, 3, 7, 9, 5, 6, 9};

    public static void main(String[] args) {
        System.out.println("is " + NUMBER + " in array: " + findNumberInArray(NUMBER, ARRAY));
    }

    private static boolean findNumberInArray(int n, int[] array) {
        if (array.length == 1) {
            return array[0] == n;
        } else {
            int middle = array.length / 2;
            return findNumberInArray(n, Arrays.copyOfRange(array, 0, middle)) ||
                    findNumberInArray(n, Arrays.copyOfRange(array, middle, array.length));

        }
    }
}
