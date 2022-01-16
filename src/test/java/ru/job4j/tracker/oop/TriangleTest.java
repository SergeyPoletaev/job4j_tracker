package ru.job4j.tracker.oop;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void whenTriangleNotExistThenAreaMinus1() {
        Point a = new Point(0, 1);
        Point b = new Point(2, 3);
        Point c = new Point(4, 5);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double exp = -1;
        Assert.assertEquals(exp, rsl, 0.01);
    }

    @Test
    public void whenTriangleExist() {
        Point a = new Point(0, 1);
        Point b = new Point(1, 2);
        Point c = new Point(2, 1);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double exp = 0.99;
        Assert.assertEquals(exp, rsl, 0.01);
    }
}