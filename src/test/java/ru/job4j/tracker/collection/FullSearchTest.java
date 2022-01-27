package ru.job4j.tracker.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class FullSearchTest {

    @Test
    public void extract() {
        List<Task> tasks = List.of(
                new Task("1", "test1"),
                new Task("2", "test2"),
                new Task("1", "test3")
        );
        Set<String> rsl = FullSearch.extract(tasks);
        Set<String> exp = Set.of("1", "2");
        Assert.assertEquals(exp, rsl);
    }
}