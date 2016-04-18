package ch.yvesbeutler.models.animals;

import ch.yvesbeutler.models.animals.enums.BloodType;
import ch.yvesbeutler.models.animals.enums.Nutrition;

/**
 * @author yvesbeutler
 * This class represents the super class of every kind of animal with
 * few basic attributes such as name, average age and nutrition.
 */
public abstract class Animal {

    private String name;
    private int age;
    private Nutrition nutrition;
    private BloodType bloodtype;

    public Animal(String name, int age, Nutrition nutrition, BloodType bloodType) {
        this.name = name;
        this.age = age;
        this.nutrition = nutrition;
        this.bloodtype = bloodType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }

    public BloodType getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(BloodType bloodtype) {
        this.bloodtype = bloodtype;
    }
}