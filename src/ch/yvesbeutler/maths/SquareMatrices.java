package ch.yvesbeutler.maths;

import java.util.Random;

/**
 * @author yvesbeutler
 * Write a program that computes the product of twho square matrices of boolean values, using the or operation
 * instead of + and the and operation instead of *. The size of the matrices depend on the integer value you
 * pass as an argument.
 */
public class SquareMatrices {

    private static Random rnd = new Random();

    public static void main(String[] args) {

        try {

            // define size of square matrix
            int i = Integer.parseInt(args[0]);

            // create 2 random square matrices
            boolean[][] matrixA = new boolean[i][i];
            boolean[][] matrixB = new boolean[i][i];

            for (int x = 0; x < i; x++) {
                for (int y = 0; y < i; y++) {
                    matrixA[x][y] = rnd.nextBoolean();
                    matrixB[x][y] = rnd.nextBoolean();
                }
            }

            // print out the matrices
            System.out.print("[Matrix A]");
            for (int z = 0; z < 2 + (i*2-2); z++) {
                System.out.print("\t");
            }
            System.out.print("[Matrix B]");
            System.out.println();

            for (int x = 0; x < i; x++) {
                for (int y = 0; y < i; y++) {
                    System.out.print(matrixA[x][y] + "\t");
                }
                System.out.print("\t\t");
                for (int y = 0; y < i; y++) {
                    System.out.print(matrixB[x][y] + "\t");
                }
                System.out.println();
            }

            System.out.println();
            System.out.println("Now do some freakin' magic..");
            System.out.println();
            System.out.println("[Matrix AB]");

            boolean[][] matrixAB = new boolean[i][i];

            for (int x = 0; x < i; x++) {
                for (int y = 0; y < i; y++) {
                    matrixAB[x][y] = calculateMatrixValue(x, y, matrixA, matrixB);
                    System.out.print(matrixAB[x][y] + "\t");
                }
                System.out.println();
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please insert an argument");
        } catch (NumberFormatException e) {
            System.out.println("Please insert an int as argument");
        }
    }

    /**
     * Calculates the logical value of the field [x][y] of two given boolean arrays.
     * @param x row index
     * @param y column index
     * @param matrixA first matrix
     * @param matrixB second matrix
     * @return logical product of the two matrices
     */
    private static boolean calculateMatrixValue(int x, int y, boolean[][] matrixA, boolean[][] matrixB) {

        boolean[] results = new boolean[matrixA.length];

        for (int i = 0; i < matrixA.length; i++) {
            results[i] = Boolean.logicalAnd(matrixA[x][i], matrixB[i][y]);
        }

        // check if at least one value is TRUE
        for (boolean val : results) {
            if (val) {
                return true;
            }
        }
        return false;
    }

}