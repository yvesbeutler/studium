package ch.yvesbeutler.maths;

/**
 * @author yvesbeutler
 * @since 04.03.2016
 * Task: Which of the following s loops computes this sum [pi^2/6]?
 */
public class ArithmeticExceptions {

    private final static int N = 1000000;

    public static void main(String[] args) {

        double sum = 0d;
        System.out.println("--------> This is Loop A <--------");
        try {
            for (int i = 1; i <= N; i++) {
                sum = sum + 1 / (i * i);
            }
        } catch (ArithmeticException e) {
            System.out.println("sum = ArithmeticException");
            System.out.println("1 / (65536 * 65536) ==> 1 / (0) ==> division by zero");
        }
        System.out.println();

        sum = 0d;
        System.out.println("--------> This is Loop B <--------");
        for (int i = 1; i <= N; i++) {
            sum = sum + 1.0 / i * i;
        }
        System.out.println("sum = " + sum);
        System.out.println("1.0 / i * i ==> (1.0 / i) * i ==> 1");
        System.out.println();


        sum = 0d;
        System.out.println("--------> This is Loop C <--------");
        for (int i = 1; i <= N; i++) {
            sum = sum + 1.0 / (i * i);
        }
        System.out.println("sum = " + sum);
        System.out.println("1.0 / (65536 * 65536) ==> 1.0 / (0.0) ==> undefined");
        System.out.println();


        sum = 0d;
        System.out.println("--------> This is Loop D <--------");
        for (int i = 1; i <= N; i++) {
            sum = sum + 1 / (1.0 * i * i);
        }
        System.out.println("sum = " + sum);
        System.out.println("it works!");

    }
}