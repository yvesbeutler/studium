package ch.yvesbeutler.generics.exercises;

/**
 * Will the following Class compile? If not, why?
 *
 * @author yvesbeutler
 * @since 16.03.2016
 */
public class Exercise02 {

    /**
     * This won't compile because you can't compare any pairs of object
     */
    public static <T> T max(T first, T second) {
        //return first > second ? first : second;
        return null;
    }

    /**
     * This would be a possible solution for the given problem
     */
    public static <T extends Comparable> T max(T first, T second) {
        return first.compareTo(second) > 0 ? first : second;
    }
}
