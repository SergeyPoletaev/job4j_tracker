package ru.job4j.tracker.oop;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        double dist = a.distance(b);
        System.out.println("Distance from point " + a + " to point " + b + " = " + dist);
    }
}
