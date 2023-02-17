package ru.job4j.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key, Predicate<Person> pers) {
        Predicate<Person> compareName = Comparator.comparing(Person::getName);
        Predicate<Person> compareSurname = Comparator.comparing(Person::getSurname);
        Predicate<Person> comparePhone = Comparator.comparing(Person::getPhone);
        Predicate<Person> compareAddress = Comparator.comparing(Person::getAddress);
        Predicate<Person> combine = compareName.thenComparing(compareSurname).thenComparing(comparePhone).thenComparing(compareAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
