package ru.job4j.tracker.poly;

public class Airplane implements Vehicle {
    private static final double TAX = 18.4;

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " flies through the air");
    }

    @Override
    public double profit(int flight) {
        return TAX * flight;
    }
}
