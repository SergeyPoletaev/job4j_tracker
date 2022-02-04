package ru.job4j.tracker.stream;

import java.time.LocalDate;

public class Car {
    private String brand;
    private String model;
    private LocalDate created;
    private double volume;
    private String color;

    static class Builder {
        private String brand;
        private String model;
        private LocalDate created;
        private double volume;
        private String color;

        public Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        public Builder buildCreated(LocalDate created) {
            this.created = created;
            return this;
        }

        public Builder buildVolume(double volume) {
            this.volume = volume;
            return this;
        }

        public Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.created = created;
            car.volume = volume;
            car.color = color;
            return car;
        }
    }

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", created=" + created
                + ", volume=" + volume
                + ", color='" + color + '\''
                + '}';
    }

    public static void main(String[] args) {
        Car carFirst = new Builder()
                .buildBrand("Toyota")
                .buildModel("Camry")
                .buildCreated(LocalDate.of(2021, 6, 1))
                .buildVolume(2.5)
                .buildColor("Red")
                .build();
        System.out.println(carFirst);
        Car carSecond = new Builder()
                .buildBrand("Lada")
                .buildColor("Red")
                .buildCreated(LocalDate.of(2021, 2, 3))
                .build();
        System.out.println(carSecond);
    }
}
