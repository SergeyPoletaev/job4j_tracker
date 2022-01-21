package ru.job4j.tracker.poly;

public class Bus implements Transport {
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
}
