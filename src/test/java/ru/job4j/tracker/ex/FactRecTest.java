package ru.job4j.tracker.ex;

import org.junit.Assert;
import org.junit.Test;

public class FactRecTest {

    @Test
    public void when3ThenFact6() {
        Assert.assertEquals(6, FactRec.fact(3));
    }

    @Test
    public void when0ThenFact1() {
        Assert.assertEquals(1, FactRec.fact(0));
    }

    @Test
    public void when1ThenFact1() {
        Assert.assertEquals(1, FactRec.fact(1));
    }

    @Test(expected = StackOverflowError.class)
    public void whenInvalidThenFactErr() {
        FactRec.fact(-1);
    }
}