package ru.job4j.tracker.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = o2.substring(0, 2).compareTo(o1.substring(0, 2));
        return rsl != 0 ? rsl : o1.substring(2).compareTo(o2.substring(2));
    }
}
