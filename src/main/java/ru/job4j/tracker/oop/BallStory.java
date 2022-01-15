package ru.job4j.tracker.oop;

public class BallStory {

    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        System.out.println("Ball met a hare. The hare tried to eat a ball.");
        hare.tryEat(ball, false);
        System.out.println("Ball met a wolf. The wolf tried to eat a ball.");
        wolf.tryEat(ball, false);
        System.out.println("Ball met a fox. The fox tried to eat a ball.");
        fox.tryEat(ball, true);
    }
}
