package ru.job4j.tracker.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {

    public static Set<String> extract(List<Task> tasks) {
        Set<String> rsl = new HashSet<>();
        for (Task task : tasks) {
            rsl.add(task.getNumber());
        }
        return rsl;
    }
}
