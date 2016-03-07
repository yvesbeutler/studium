package ch.yvesbeutler.maths;

import java.util.Scanner;

/**
 * @author Samuel Ackermann
 * @since 04.03.2016
 * Write a program Stats.java that takes an integer N from the command line, reads N double values from standard
 * input, and prints their mean (average value) and sample standard deviation (square core of the sum of the squares
 * of their differences from the average, divided by N - 1).
 */
public class StandardDeviation {

    public static void main(String[] args) {

        int n = 0;
        try {
            n = Integer.parseInt(args[0]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("no argument defined");
            System.exit(1);
        }
        if ( n <= 0) {
            System.out.println("number isn't larger than 0");
            System.exit(1);
        }

        Scanner scan = new Scanner(System.in);
        double[]doubleList = new double[n];
        double sum = 0;

        System.out.println("please input " + args[0] + " values of type double:");
        for (int i = 0; i < n; i++) {
            doubleList[i] = scan.nextDouble();
            sum += doubleList[i];
        }

        double avg = sum / n;
        System.out.printf("the average of all inserted numbers is: %f", avg);
        System.out.println();

        double avgDiff = 0;
        for (int i = 0; i < n; i++) {
            avgDiff += Math.pow((doubleList[i] - avg), 2);
        }

        double stdDeviation = Math.sqrt(1 / ((double)n - 1) * avgDiff);
        System.out.printf("the standard deviation is: %f", stdDeviation);
    }

}