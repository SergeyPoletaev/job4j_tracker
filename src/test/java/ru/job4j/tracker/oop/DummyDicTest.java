package ru.job4j.tracker.oop;

import junit.framework.TestCase;
import org.junit.Assert;

public class DummyDicTest extends TestCase {

    public void testEngToRus() {
        String eng = "Holiday";
        String rsl = new DummyDic().engToRus(eng);
        String exp = "Неизвестное слово. Holiday";
        Assert.assertEquals(exp, rsl);
    }
}