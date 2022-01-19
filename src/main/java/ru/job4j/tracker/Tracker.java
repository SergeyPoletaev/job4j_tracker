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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            items[index].setName(item.getName());
            rsl = true;
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < size; i++) {
            if (id == items[i].getId()) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}