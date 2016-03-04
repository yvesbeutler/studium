package ch.yvesbeutler.maths;

/**
 * @author Dario Carosella
 * @since 04.03.2016
 * Given two vectors of length N that are represented with one-dimensional arrays, write a code fragment that
 * computes the Euclidean distance between them (the square core of the sums of the squares of the differences
 * between corresponding entries).
 */
public class EuclideanDistance {

    public static void main(String[] args) {
        int length = 5;
        double[] vector1 = new double[3];
        double[] vector2 = new double[3];

        //x and y is given for the two vectors
        vector1[0] = -4;
        vector1[1] = -1;

        vector2[0] = 2;
        vector2[1] = 3;

        //calculate z
        vector1[2] = Math.sqrt(Math.pow(length, 2) - Math.pow(vector1[0], 2) - Math.pow(vector1[1], 2));
        vector2[2] = Math.sqrt(Math.pow(length, 2) - Math.pow(vector2[0], 2) - Math.pow(vector2[1], 2));

        //computes the Euclidean distance
        double sum = 0;
        for (int i = 0; i < vector1.length; i++) {
            sum += Math.pow(vector1[i] - vector2[i], 2);
        }

        System.out.println("Euclidean distance is:");
        System.out.println(Math.sqrt(sum));
    }

}