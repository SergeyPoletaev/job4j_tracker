package ru.job4j.tracker.collection;

import org.junit.Assert;
import org.junit.Test;

public class PassportOfficeTest {

    @Test
    public void whenAddUniqueThenTrue() {
        Assert.assertTrue(new PassportOffice().add(new Citizen("789", "Anna")));
    }

    @Test
    public void whenAddDuplicateThenFalse() {
        PassportOffice office = new PassportOffice();
        office.add(new Citizen("123", "Anna"));
        Assert.assertFalse(office.add(new Citizen("123", "Peter")));
    }

    @Test
    public void get() {
        PassportOffice office = new PassportOffice();
        Citizen citizen = new Citizen("123", "Anna");
        office.add(citizen);
        Assert.assertEquals(citizen.getUsername(), office.get("123").getUsername());
    }
}