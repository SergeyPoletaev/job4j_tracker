package ru.job4j.tracker.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ConvertListTest {

    @Test
    public void convert() {
        List<int[]> list = List.of(new int[]{1, 2, 3}, new int[]{4, 5});
        List<Integer> rsl = ConvertList.convert(list);
        List<Integer> exp = List.of(1, 2, 3, 4, 5);
        Assert.assertEquals(exp, rsl);
    }

}