package ch.yvesbeutler.models.animals;

import ch.yvesbeutler.models.animals.enums.BloodType;
import ch.yvesbeutler.models.animals.enums.Nutrition;

/**
 * @author yvesbeutler
 * This class represents mammals, which are warmblooded animals.
 */
public class Mammal extends Animal {

    private int weight;
    private int numberOfYoung;

    public Mammal(String name, int age, Nutrition nutrition, int weight, int numberOfYoung) {
        super(name, age, nutrition, BloodType.WARM);
        this.weight = weight;
        this.numberOfYoung = numberOfYoung;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getNumberOfYoung() {
        return numberOfYoung;
    }

    public void setNumberOfYoung(int numberOfYoung) {
        this.numberOfYoung = numberOfYoung;
    }
}
