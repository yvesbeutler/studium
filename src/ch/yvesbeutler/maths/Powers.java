package ch.yvesbeutler.maths;

/**
 * @author yvesbeutler
 * @since 04.03.2016
 * Write a program PowersOfK that takes an integer k as command-line argument and prints all the positive powers of
 * k in the Java long data type. Note: The constant Long.MAX_VALUE is the value of the largest integer in long.
 */
public class Powers {

    public static void main(String[] args) {

        try {

            int input = Integer.parseInt(args[0]);
            long val;

            for (int i = 0; Math.pow(input, i) < Long.MAX_VALUE; i++) {
                val = (long)Math.pow(input, i);
                System.out.println(val);
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please enter an argument");
        } catch (NumberFormatException nfe) {
            System.out.println("Please enter an argument of type: int");
        }
    }

}