package ru.job4j.tracker.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        for (int i = 0; i < left.length() && i < right.length(); i++) {
            rsl = Character.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                break;
            }
        }
        if (rsl == 0 && left.length() < right.length()) {
            rsl = -1;
        }
        if (rsl == 0 && left.length() > right.length()) {
            rsl = 1;
        }
        return rsl;
    }
}
