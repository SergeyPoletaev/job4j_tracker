package ru.job4j.tracker.ex;

import org.junit.Assert;
import org.junit.Test;

public class FindElTest {

    @Test(expected = ElementNotFoundEx.class)
    public void whenElNotFoundThenIndexOfEx() throws ElementNotFoundEx {
        String[] arr = {"1", "2"};
        String key = "3";
        new FindEl().indexOf(arr, key);
    }

    @Test
    public void whenEl2FoundThenIndexOf1() throws ElementNotFoundEx {
        String[] arr = {"1", "2"};
        String key = "2";
        Assert.assertEquals(new FindEl().indexOf(arr, key), 1);
    }
}