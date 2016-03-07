package ch.yvesbeutler.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author yvesbeutler
 * @since 07.03.2016
 * This class demonstrates the use of lambda expressions with an example of a simple comparator.
 */
public class ComparatorTest {

    public static void main(String[] args) {

        List<Person> persons = Person.createShortList();

        // VARIANT 1: SORT WITH INNER CLASSES
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getFirstName().compareTo(p2.getFirstName());
            }
        });

        System.out.println("Sorted with inner classes");
        for (Person p : persons) {
            p.print();
        }


        // VARIANT 2: SORT WITH LAMBDAS
        Collections.sort(persons, (Person p1, Person p2) -> p1.getFirstName().compareTo(p2.getFirstName()));

        System.out.println("Sorted with lambdas");
        for (Person p : persons) {
            p.print();
        }


        // VARIANT 2.1: IF IT'S THE SAME TYPE, THEN NO TYPE DEFINITION IS NEEDED
        Collections.sort(persons, (p1, p2) -> p2.getFirstName().compareTo(p1.getFirstName()));

        System.out.println("Sorted reverse with lambdas");
        for (Person p : persons) {
            p.print();
        }

    }

}

/**
 * A simple POJO to demonstrate lambda expressions.
 */
class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public static List<Person> createShortList() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Yves", "Beutler", 22));
        persons.add(new Person("Angi", "Herrli", 21));
        persons.add(new Person("Serge", "Oberli", 19));
        persons.add(new Person("Yves", "Saint-Laurent", 64));
        persons.add(new Person("Andreas", "Linder", 24));
        persons.add(new Person("Arnold", "Schwarzenegger", 62));
        return persons;
    }

    public void print() {
        System.out.println(firstName + "\t" + lastName);
    }

    public String getFirstName() {
        return firstName;
    }
}
