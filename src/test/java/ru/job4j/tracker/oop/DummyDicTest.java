package ru.job4j.tracker.oop;

import org.junit.Assert;
import org.junit.Test;

public class DummyDicTest {

    @Test
    public void testEngToRus() {
        String eng = "Holiday";
        String rsl = new DummyDic().engToRus(eng);
        String exp = "Неизвестное слово. Holiday";
        Assert.assertEquals(exp, rsl);
    }
}