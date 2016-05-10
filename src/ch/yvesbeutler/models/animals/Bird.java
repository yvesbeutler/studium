package ch.yvesbeutler.models.animals;

import ch.yvesbeutler.models.animals.enums.BloodType;
import ch.yvesbeutler.models.animals.enums.Nutrition;

/**
 * @author yvesbeutler
 * This class represents any kind of birds, which are warm-blooded and can fly.
 */
public class Bird extends Animal {

    private int airSpeed;

    public Bird(String name, int age, Nutrition nutrition, int airSpeed) {
        super(name, age, nutrition, BloodType.WARM);
        this.airSpeed = airSpeed;
    }

    public int getAirSpeed() {
        return airSpeed;
    }

    public void setAirSpeed(int airSpeed) {
        this.airSpeed = airSpeed;
    }
}
