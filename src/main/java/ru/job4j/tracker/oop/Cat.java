package ru.job4j.tracker.oop;

public class Cat {
    private String food;
    private String name;

    public void show() {
        System.out.println("Food kitten " + this.name + " is " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}
