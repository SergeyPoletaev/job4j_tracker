package ru.job4j.tracker.poly;

public class DbStore implements Store {

    public void save(String value) {
        System.out.println("DbStore " + value);
    }

    public String[] load() {
        return new String[]{};
    }
}
