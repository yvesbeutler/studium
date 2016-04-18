package ch.yvesbeutler.streams;

import ch.yvesbeutler.models.translators.Language;
import ch.yvesbeutler.models.translators.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yvesbeutler
 * This class demonstrates how Java 8 streams work with an example of an translation office which has
 * several employees who can speak different languages.
 */
public class Translators {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Tobi", 31, Arrays.asList(Language.German, Language.French)));
        personList.add(new Person("Joris", 25, Arrays.asList(Language.French)));
        personList.add(new Person("Mathew", 24, Arrays.asList(Language.German, Language.Malayalam)));
        personList.add(new Person("Yves", 23, Arrays.asList(Language.German, Language.French, Language.English)));
        personList.add(new Person("Tobi", 73, Arrays.asList(Language.German)));
        personList.add(new Person("Dario", 24, Arrays.asList(Language.German, Language.English)));

        System.out.println("Step 1: Print the whole stream");
        personList.stream()
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Step 2: Sort first by age and then name");
        personList.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Step 3: Calculate the average age of all persons");
        System.out.println(personList.stream().mapToInt(person -> person.getAge()).average().getAsDouble());

        System.out.println();
        System.out.println("Step 4: Find the youngest person in the stream");
        Optional<Person> youngest = personList.stream().reduce((p1, p2) -> (p1.getAge() <= p2.getAge() ? p1 : p2));
        System.out.println(youngest.get().getAge());

        System.out.println();
        System.out.println("Step 5: List all languages");
        Set<Language> allLanguages = personList.stream().flatMap(p -> p.getLanguages().stream()).collect(Collectors.toSet());
        System.out.println(allLanguages);

    }

}
