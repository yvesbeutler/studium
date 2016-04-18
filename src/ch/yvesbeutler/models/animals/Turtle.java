package ch.yvesbeutler.models.animals;

import ch.yvesbeutler.models.animals.enums.Nutrition;

/**
 * @author yvesbeutler
 * This class represents a turtle, which lives in the sea instead of the land like turtoises.
 * Turtles are generally omnivores and eat all kinds of nutrition.
 */
public class Turtle extends Reptile {

    public Turtle(String name, int age, Nutrition nutrition, int numberOfEggs) {
        super(name, age, Nutrition.OMNIVORE, numberOfEggs);
    }
}
