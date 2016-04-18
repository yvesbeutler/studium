package ch.yvesbeutler.models.animals;

import ch.yvesbeutler.models.animals.enums.Nutrition;

/**
 * @author yvesbeutler
 * This class represents a snake, which is a reptile with a specific length.
 */
public class Snake extends Reptile {

    private int length;

    public Snake(String name, int age, Nutrition nutrition, int numberOfEggs, int length) {
        super(name, age, nutrition, numberOfEggs);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
