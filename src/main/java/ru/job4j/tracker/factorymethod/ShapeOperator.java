package ru.job4j.tracker.factorymethod;

public abstract class ShapeOperator {

    public void showInfo() {
        Shape shape = createShape();
        System.out.println(shape.draw());
        System.out.println("Полощадь фигуры равна: " + shape.square());
    }

    public abstract Shape createShape();

}
