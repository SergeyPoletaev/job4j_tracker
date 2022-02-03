package ru.job4j.tracker.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> rsl = new ArrayList<>();
        Predicate<Person> predName = p -> p.getName().contains(key);
        Predicate<Person> predSurname = p -> p.getSurname().contains(key);
        Predicate<Person> predPhone = p -> p.getPhone().contains(key);
        Predicate<Person> predAddress = p -> p.getAddress().contains(key);
        Predicate<Person> combine = predName.or(predSurname).or(predPhone).or(predAddress);
        for (Person person : this.persons) {
            if (combine.test(person)) {
                rsl.add(person);
            }
        }
        return rsl;
    }
}
