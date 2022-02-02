package ru.job4j.tracker.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.function.Function;

public class CalcTest {

    @Test
    public void whenLinearFuncThenLinearResult() {
        int start = 2;
        int end = 5;
        Function<Double, Double> func = x -> 2 * x + 3;
        List<Double> exp = List.of(7D, 9D, 11D);
        List<Double> rsl = Calc.diapason(start, end, func);
        Assert.assertEquals(exp, rsl);
    }

    @Test
    public void whenQuadraticFuncThenQuadraticResult() {
        int start = 2;
        int end = 5;
        Function<Double, Double> func = x -> x * x + 3;
        List<Double> exp = List.of(7D, 12D, 19D);
        List<Double> rsl = Calc.diapason(start, end, func);
        Assert.assertEquals(exp, rsl);
    }

    @Test
    public void whenExpFuncThenExpResult() {
        int start = 2;
        int end = 5;
        Function<Double, Double> func = x -> Math.pow(2, x);
        List<Double> exp = List.of(4D, 8D, 16D);
        List<Double> rsl = Calc.diapason(start, end, func);
        Assert.assertEquals(exp, rsl);
    }
}