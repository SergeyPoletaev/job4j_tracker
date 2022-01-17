package ru.job4j.tracker.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when00To11ThenDistance1Dot41() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        double rsl = a.distance(b);
        double exp = 1.41;
        Assert.assertEquals(exp, rsl, 0.01);
    }

    @Test
    public void when11To11ThenDistance0Dot0() {
        Point a = new Point(1, 1);
        Point b = new Point(1, 1);
        double rsl = a.distance(b);
        double exp = 0.0;
        Assert.assertEquals(exp, rsl, 0.01);
    }

    @Test
    public void when23To45ThenDistance2Dot82() {
        Point a = new Point(2, 3);
        Point b = new Point(4, 5);
        double rsl = a.distance(b);
        double exp = 2.82;
        Assert.assertEquals(exp, rsl, 0.01);
    }

    @Test
    public void when000To111ThenDistance3D1Dot41() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 1, 1);
        double rsl = a.distance3d(b);
        double exp = 1.73;
        Assert.assertEquals(exp, rsl, 0.01);
    }

    @Test
    public void when111To111ThenDistance3D0Dot0() {
        Point a = new Point(1, 1, 1);
        Point b = new Point(1, 1, 1);
        double rsl = a.distance3d(b);
        double exp = 0.0;
        Assert.assertEquals(exp, rsl, 0.01);
    }

    @Test
    public void when234To567ThenDistance3D5Dot19() {
        Point a = new Point(2, 3, 4);
        Point b = new Point(5, 6, 7);
        double rsl = a.distance3d(b);
        double exp = 5.19;
        Assert.assertEquals(exp, rsl, 0.01);
    }
}