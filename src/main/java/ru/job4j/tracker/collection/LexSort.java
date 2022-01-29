package ru.job4j.tracker.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] arrLeft = left.split("\\.");
        String[] arrRight = right.split("\\.");
        return Integer.compare(
                Integer.parseInt(arrLeft[0]), Integer.parseInt(arrRight[0])
        );
    }
}
