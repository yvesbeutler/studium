package ch.yvesbeutler.recursion;

import java.util.Arrays;

/**
 * @author yvesbeutler
 * @since 04.03.2016
 */
public class FindNumberInArray {

    private static int NUMBER = 7;
    private static int[] ARRAY = {1, 3, 6, 3, 7, 9, 5, 6, 9};

    public static void main(String[] args) {
        findNumberInArray(NUMBER, ARRAY);
    }

    private static boolean findNumberInArray(int n, int[] array) {

        // TODO: finish this example of divide and conquer

        if (array.length == 1) {
            return array[0] == n;
        } else {
            Arrays.copyOfRange(array, 0, array.length + 1 / 2);
//            return findNumberInArray(n, )
        }

//        return (array.length == 1) ? array[0] == n :

        return true;
    }

//    Boolean isIn(Number x, Array a) {
//
//        n = a.size
//        if n==1 then return a[0]==x
//        else
//        return isIn(x, a[0:n/2]) or isIn(x,a[n/2:n])
//    }

}
