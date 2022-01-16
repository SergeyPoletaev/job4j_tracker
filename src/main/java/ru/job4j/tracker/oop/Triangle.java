package ru.job4j.tracker.oop;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private boolean exist(double ab, double bc, double ac) {
        return ab + bc > ac && ab + ac > bc && ac + bc > ab;
    }

    private double semiPerimeter(double ab, double bc, double ac) {
        return (ab + bc + ac) / 2;
    }

    public double area() {
        double rsl = -1;
        double ab = a.distance(b);
        double bc = b.distance(c);
        double ac = a.distance(c);
        if (exist(ab, bc, ac)) {
            double p = semiPerimeter(ab, bc, ac);
            rsl = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
        }
        return rsl;
    }
}
