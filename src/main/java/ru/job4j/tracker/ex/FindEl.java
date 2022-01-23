package ru.job4j.tracker.ex;

public class FindEl {

    public int indexOf(String[] array, String key) throws ElementNotFoundEx {
        int rsl = -1;
        for (int i = 0; i < array.length; i++) {
            if (key.equals(array[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundEx("Element not found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] array = {"1", "2", "3"};
        String key = "4";
        try {
            new FindEl().indexOf(array, key);
        } catch (ElementNotFoundEx ex) {
            ex.printStackTrace();
        }
    }
}
