package ru.job4j.tracker.poly;

public class PolyUsage {

    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] vehicles = {airplane, train, bus};
        for (Vehicle v : vehicles) {
            v.move();
            int flight = 10;
            System.out.println("Profit for " + flight + " flights: " + v.profit(flight) + System.lineSeparator());
        }
    }
}
