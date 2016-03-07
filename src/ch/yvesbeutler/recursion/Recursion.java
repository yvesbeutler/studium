package ch.yvesbeutler.recursion;

/**
 * @author yvesbeutler
 * @since 04.03.2016
 * This examples demonstrate how recursive functions work. Every recursive function needs at
 * least one base case, which terminates the function.
 */
public class Recursion {

    final static int INPUT = 3;
    final static int INPUT2 = 7;

    public static void main(String[] args) {
        System.out.println("numbers = " + INPUT + ", " + INPUT2);
        System.out.println("------------------");
        System.out.println("natural:\t" + isN(INPUT));
        System.out.println("faculty:\t" + faculty(INPUT));
        System.out.println("fibonacci:\t" + fibonacci(INPUT));
        System.out.println("multiply:\t" + multiply(INPUT, INPUT2));
    }

    /**
     * checks if the number is natural
     */
    private static boolean isN(int n) {
        return (n == 0) ? true : isN(n-1);
    }

    /**
     * faculty(4) --> 1 * 2 * 3 * 4
     */
    private static int faculty(int n) {
        return (n == 0) ? 1 : n * faculty(--n);
    }

    /**
     * fibonacci-function
     */
    private static int fibonacci(int n) {
        return (n < 2) ? 1 : fibonacci(n-1) + fibonacci(n-2);
    }

    /**
     * multiplication
     */
    private static int multiply(int m, int n) {
        return (m < 1) ? 0 : n + multiply(m-1, n);
    }

}