package ru.job4j.tracker.poly;

public class Service {
    private Store store;

    public Service(Store store) {
        this.store = store;
    }

    public void extract() {
        store.save("Peter Arsentev");
    }
}
