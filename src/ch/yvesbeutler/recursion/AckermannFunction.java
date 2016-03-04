package ch.yvesbeutler.recursion;

/**
 * @author yvesbeutler
 * @since 04.03.2016
 * In computability theory, the Ackermann function, named after Wilhelm Ackermann, is one of the simplest and
 * earliest-discovered examples of a total computable function that is not primitive recursive.
 */
public class AckermannFunction {

    public static void main(String[] args) {
        ackermann(3, 7);
    }

    /**
     * ackermann function
     */
    private static int ackermann(int m, int n) {
        if (m == 0) {
            return n + 1;
        } else if (n == 0) {
            return ackermann(m-1, 1);
        } else {
            // perforce (m > 0) && (n > 0)
            return ackermann(m-1, ackermann(m,n-1));
        }
    }

}
