package ru.job4j.tracker.oop;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void whenFirst5Second4Third8Four1ThenMax8() {
        int first = 5;
        int second = 4;
        int third = 8;
        int four = 1;
        int rsl = new Max().max(first, second, third, four);
        int exp = 8;
        Assert.assertEquals(exp, rsl);
    }

    @Test
    public void whenFirst1Second4Third2Four1ThenMax4() {
        int first = 1;
        int second = 4;
        int third = 2;
        int four = 1;
        int rsl = new Max().max(first, second, third, four);
        int exp = 4;
        Assert.assertEquals(exp, rsl);
    }

    @Test
    public void whenFirst1Second2Third2Four1ThenMax2() {
        int first = 1;
        int second = 2;
        int third = 2;
        int four = 1;
        int rsl = new Max().max(first, second, third, four);
        int exp = 2;
        Assert.assertEquals(exp, rsl);
    }
}