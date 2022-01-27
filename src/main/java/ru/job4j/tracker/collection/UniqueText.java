package ru.job4j.tracker.collection;

import java.util.HashSet;
import java.util.Set;

public class UniqueText {

    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        Set<String> check = new HashSet<>();
        for (String str : origin) {
            check.add(str);
        }
        for (String str : text) {
            if (!check.contains(str)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
