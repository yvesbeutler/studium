package ch.yvesbeutler.generics;

import ch.yvesbeutler.models.animals.Animal;
import ch.yvesbeutler.models.animals.Dinosaur;
import ch.yvesbeutler.models.animals.Reptile;
import ch.yvesbeutler.models.animals.Snake;
import ch.yvesbeutler.models.animals.enums.Nutrition;
import ch.yvesbeutler.models.animals.enums.Period;

/**
 * @author yvesbeutler
 * This class demonstrates how generics works. It uses my animal model classes.
 */
public class GenericsTest {

    public static void main(String[] args) {

        Gen<Reptile> reptile = new Gen<>();
        reptile.setValue(new Dinosaur("Velociraptor", 32, Nutrition.CARNIVORE, 15, Period.JURASSIC));

        // raw types example
        Gen animal = new Gen(); // it's called raw type if you don't parameterize a generic class
        animal.setValue(new Integer(42)); // this can be everything because raw types use <Object> as T

        // wildcards
        // You can assign a generic of known type to a generic of wildcard type
        Gen<Animal> example = new Gen<>();
        doSomething(example);   // OK

        // You are able to call the printDetails() method with the Wrapper<Object> type, but not with the
        // Wrapper<String> type because they are not assignment compatible, which is contradictory to what your intuition tells you
        Gen<Reptile> reptileGen = new Gen<>(new Snake("Python", 30, Nutrition.CARNIVORE, 15, 6));
        //doSomething(reptileGen);    // compile-time error

        // now let's use wildcards to prevent this error
        Gen<?> wildcardGen = reptileGen;
        //doSomething(wildcardGen);

    }

    private static void doSomething(Gen<Animal> animal) {
        System.out.println("The value is: " + animal);
    }

}
