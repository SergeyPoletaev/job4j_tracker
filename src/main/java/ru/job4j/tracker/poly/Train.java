package ru.job4j.tracker.poly;

public class Train implements Vehicle {
    private static final double TAX = 12.14;

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " moves along rails");
    }

    @Override
    public double profit(int flight) {
        return TAX * flight;
    }
}
