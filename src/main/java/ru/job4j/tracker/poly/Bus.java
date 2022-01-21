package ru.job4j.tracker.poly;

public class Bus implements Transport, Vehicle {
    private static final double TAX = 8.22;

    @Override
    public void drive() {
        System.out.println("Bus goes ...");
    }

    @Override
    public void passengers(int pass) {
        System.out.println("The bus transports " + pass + " passengers");
    }

    @Override
    public double fill(double fuel) {
        double price = 51.25;
        return fuel * price;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " moves through high-speed tracks");
    }

    @Override
    public double profit(int flight) {
        return TAX * flight;
    }
}
