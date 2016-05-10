package ch.yvesbeutler.generics;

import java.util.ArrayList;

/**
 * Your task is to complete the implementation of a generic Matrix class. A matrix is a two-dimensional
 * arrangement of elements. You access elements with a row and column index.
 *
 * @author yvesbeutler
 * @since 15.03.2016
 */
public class Matrix<T> {

    private int rows;
    private int columns;
    private ArrayList<ArrayList<T>> elements;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        elements = new ArrayList<ArrayList<T>>();

        // Fill up matrix with null values
        for (int i = 0; i < rows; i++) {
            ArrayList<T> row = new ArrayList<T>();
            for (int j = 0; j < columns; j++) row.add(null);
            elements.add(row);
        }
    }

    public static void main(String[] p) {
        String s = check(2, 1, "adameva");
        System.out.println(s);
    }

    private T get(int x, int y) {
        return elements.get(x).get(y);
    }

    private void put(int x, int y, T z) {
        elements.get(x).set(y, z);
    }

    // the following method is used to check your work
    public static String check(int r, int c, String s) {
        int matrixDimRow = 5;
        int matrixDimCol = 6;
        Matrix<String> m = new Matrix<String>(matrixDimRow, matrixDimCol);

        // add letters of s diagonally
        for (int i = 0; i < s.length(); i++) {
            m.put(r, c, s.substring(i, i + 1));
            r++;
            if (r >= matrixDimRow) r = 0;
            c++;
            if (c >= matrixDimCol) c = 0;
        }

        // make string representing matrix content
        String t = "";
        for (int i = 0; i < matrixDimRow; i++)
            for (int j = 0; j < matrixDimCol; j++)
                if (m.get(i, j) == null) t += ".";
                else t += m.get(i, j);
        return t;
    }
}