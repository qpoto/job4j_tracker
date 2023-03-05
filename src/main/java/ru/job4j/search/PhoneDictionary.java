package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> compareName = person -> person.getName().contains(key);
        Predicate<Person> compareSurname = person -> person.getSurname().contains(key);
        Predicate<Person> comparePhone = person -> person.getPhone().contains(key);
        Predicate<Person> compareAddress = person -> person.getAddress().contains(key);
        var combine = compareName.or(compareSurname).or(comparePhone).or(compareAddress);
        var result = new ArrayList<Person>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
