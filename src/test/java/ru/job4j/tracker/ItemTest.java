package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.collection.ItemAskByName;
import ru.job4j.tracker.collection.ItemDescByName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemTest {

    @Test
    public void whenNaturalOrderSort() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "test3"));
        items.add(new Item(2, "test1"));
        items.add(new Item(3, "test2"));
        List<Item> exp = new ArrayList<>();
        exp.add(new Item(2, "test1"));
        exp.add(new Item(3, "test2"));
        exp.add(new Item(1, "test3"));
        Collections.sort(items, new ItemAskByName());
        Assert.assertEquals(exp, items);
    }

    @Test
    public void whenReverseOrderSort() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "test3"));
        items.add(new Item(2, "test1"));
        items.add(new Item(3, "test2"));
        List<Item> exp = new ArrayList<>();
        exp.add(new Item(1, "test3"));
        exp.add(new Item(3, "test2"));
        exp.add(new Item(2, "test1"));
        Collections.sort(items, new ItemDescByName());
        Assert.assertEquals(exp, items);
    }

}