package ru.job4j.tracker.ex;

import org.junit.Assert;
import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNotValidArgThenCalcEx() {
        new Fact().calc(-1);
    }

    @Test()
    public void when5ThenCalc120() {
        Assert.assertEquals(120, new Fact().calc(5));
    }
}