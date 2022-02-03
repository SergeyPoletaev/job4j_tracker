package ru.job4j.tracker.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> pred) {
        return students.stream()
                .filter(pred)
                .collect(Collectors.toList());
    }
}
