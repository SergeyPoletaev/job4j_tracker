package ru.job4j.tracker.strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return "___________" + ln
                + "|         |" + ln
                + "|         |" + ln
                + "|         |" + ln
                + "-----------" + ln;
    }
}
