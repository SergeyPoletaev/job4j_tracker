package ru.job4j.tracker.poly;

public class Program {

    public static void main(String[] args) {
        Store store = new FileStore();
        Service service = new Service(store);
        service.extract();
    }
}
