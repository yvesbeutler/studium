package ch.yvesbeutler.sorting;

/**
 * @author yvesbeutler
 * @since 04.03.2016
 * This sample deals with bit operations like bit shifting and complements
 */
public class BitShifting {

    public static void main(String[] args) {

        byte a = 10;
        byte b = -5;

        System.out.println("a = 0000" + Integer.toBinaryString(a));
        System.out.println("b = " + Integer.toBinaryString(b).substring(24));
        System.out.println();

        // Complements
        System.out.println("~a\t\t=\t" + ~a); // 11110101
        System.out.println("~b\t\t=\t" + ~b); // 00000100
        System.out.println();

        // Logical AND
        System.out.println("a&b\t\t=\t" + Integer.toString(a&b)); // 0000 1010 & 1111 1011 = 0000 1010

        // Logical OR
        System.out.println("a|b\t\t=\t" + Integer.toString(a|b)); // 0000 1010 | 1111 1011 = 1111 1011

        // Logical XOR
        System.out.println("a^b\t\t=\t" + Integer.toString(a^b)); // 0000 1010 ^ 1111 1011 = 1111 0001
        System.out.println();

        // Bit shifting
        System.out.println("a<<2\t=\t" + Integer.toString(a<<2)); // 0000 1010 = 0010 10[00]
        System.out.println("a>>2\t=\t" + Integer.toString(a>>2)); // 0000 1010 = [00]00 0010
        System.out.println("b>>2\t=\t" + Integer.toString(b>>2)); // 1111 1011 = [11]11 1110

        // Bit shifting right (only with 0's)
        // b>>>2 : 1111 1011 = [00]11 1110

    }
}
