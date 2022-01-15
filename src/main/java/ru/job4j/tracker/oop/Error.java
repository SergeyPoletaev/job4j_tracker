package ru.job4j.tracker.oop;

public class Error {
    private boolean active;
    private int status;
    private String massage;

    public Error() {
    }

    public Error(boolean active, int status, String massage) {
        this.active = active;
        this.status = status;
        this.massage = massage;
    }

    public void printInfo() {
        System.out.println("active = " + active);
        System.out.println("status = " + status);
        System.out.println("massage = " + massage);
    }

    public static void main(String[] args) {
        Error defaultError = new Error();
        defaultError.printInfo();
        System.out.println();
        Error initError = new Error(true, 42, "Ok");
        initError.printInfo();
    }
}
