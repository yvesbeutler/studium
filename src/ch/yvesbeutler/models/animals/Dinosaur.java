package ch.yvesbeutler.models.animals;

import ch.yvesbeutler.models.animals.enums.Nutrition;
import ch.yvesbeutler.models.animals.enums.Period;

/**
 * @author yvesbeutler
 * This class represents dinosaurs, a extinct species of reptiles.
 */
public class Dinosaur extends Reptile {

    private Period period;

    public Dinosaur(String name, int age, Nutrition nutrition, int numberOfEggs, Period period) {
        super(name, age, nutrition, numberOfEggs);
        this.period = period;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}
