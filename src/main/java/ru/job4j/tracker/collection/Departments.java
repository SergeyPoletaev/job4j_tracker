package ru.job4j.tracker.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> stringSet = new LinkedHashSet<>();
        for (String str : deps) {
            String s = "";
            for (String el : str.split("/")) {
                stringSet.add(s + el);
                s = el + "/";
            }
        }
        return new ArrayList<>(stringSet);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
