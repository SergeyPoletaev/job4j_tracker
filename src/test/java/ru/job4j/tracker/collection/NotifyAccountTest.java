package ru.job4j.tracker.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = List.of(
                new Account("123", "anna", "589"),
                new Account("567", "nik", "589"),
                new Account("123", "anna", "589")
        );
        Set<Account> exp = Set.of(
                new Account("123", "anna", "589"),
                new Account("567", "nik", "589")
        );
        Set<Account> rsl = NotifyAccount.sent(accounts);
        Assert.assertEquals(exp, rsl);
    }
}