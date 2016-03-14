package ch.yvesbeutler.generics.exercises;

import java.util.*;

/**
 * Write a generic method to count the number of elements in a collection that have a specific
 * property (for example, odd integers, prime numbers, palindromes).
 *
 * @author yvesbeutler
 * @since 11.03.2016
 */
public class Exercise01 {

    public static void main(String[] args) {

        // define some types of collection
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(21, 42, 36, 23, 25, 27, 62, 84, 65, 96));
        Set<Integer> set = new HashSet<>();
        set.add(21);
        set.add(42);
        set.add(36);
        set.add(23);
        set.add(25);
        set.add(27);
        set.add(62);
        set.add(84);
        set.add(65);
        set.add(96);

        calculateOdds(arrList);
        calculateOdds(set);

    }

    // returns the number of odds for any kind of collection
    public static <T extends Collection<Integer>> void calculateOdds(T collection) {
        int count = 0;
        for(Integer i : collection) {
            if (i != null && i % 2 == 1) {
                count++;
            }
        }

        System.out.println("Number of odds is " + count);
    }
}
