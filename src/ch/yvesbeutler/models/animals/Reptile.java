package ch.yvesbeutler.models.animals;

import ch.yvesbeutler.models.animals.enums.BloodType;
import ch.yvesbeutler.models.animals.enums.Nutrition;

/**
 * @author yvesbeutler
 * This class represents any type of reptilia, which are generally cold-blooded.
 */
public abstract class Reptile extends Animal {

    private int numberOfEggs;

    public Reptile(String name, int age, Nutrition nutrition, int numberOfEggs) {
        super(name, age, nutrition, BloodType.COLD);
        this.numberOfEggs = numberOfEggs;
    }

    public int getNumberOfEggs() {
        return numberOfEggs;
    }

    public void setNumberOfEggs(int numberOfEggs) {
        this.numberOfEggs = numberOfEggs;
    }
}
