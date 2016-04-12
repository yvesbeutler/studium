package ch.yvesbeutler.streams.model;

import java.util.List;

/**
 * @author yves.beutler
 * @since 12.04.2016
 * This class represents a person which has an age and can speak several languages.
 */
public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private List<Language> languages;

    public Person(String name, int age, List<Language> languages) {
        this.name = name;
        this.age = age;
        this.languages = languages;
    }

    public String toString() {
        return name + " (" + age + ") " + languages;
    }

    public int compareTo(Person p) {
       if (this.age == p.getAge()) {
           return name.compareTo(p.getName());
       } else {
           return this.age - p.getAge();
       }
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Person) {
            return (compareTo((Person)o) == 0);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(age).hashCode() * name.hashCode();
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

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }
}
