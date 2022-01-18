package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemsWithNull = new Item[100];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                itemsWithNull[count++] = items[i];
            }
        }
        return Arrays.copyOf(itemsWithNull, count);
    }

    public Item[] findByName(String key) {
        Item[] itemsWithNull = new Item[100];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                itemsWithNull[count++] = items[i];
            }
        }
        return Arrays.copyOf(itemsWithNull, count);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}