package ru.job4j.tracker.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу сервиса по осуществлению банковских переводов.
 *
 * @author Sergey Poletaev
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных о клиентах осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в коллекцию при условии, что такого пользователя еще нет.
     * @param user пользователь, который добавляется в коллекцию.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет аккаунт к существующему пользователю.
     * @param passport идентификатор паспорта пользователя.
     * @param account аккаунт, который добавляется пользователю.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод осуществляет поиск пользователя по паспортным данным.
     * @param passport идентификатор паспорта пользователя.
     * @return при успешном поиске возвращает найденного пользователя, иначе null.
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод осуществляет поиск аккаунта по паспортным данным пользователя и реквизитам аккаунта,
     * связанного с этим пользователем.
     * @param passport идентификатор паспорта пользователя.
     * @param requisite идентификатор реквизитов аккаунта.
     * @return при успешном поиске возвращает найденный аккаунт, иначе null.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (requisite.equals(account.getRequisite())) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод осуществляет перевод денег с одного аккаунта на другой.
     * @param srcPassport идентификатор паспорта источника.
     * @param srcRequisite идентификатор реквизитов аккаунта источника.
     * @param destPassport идентификатор паспорта получателя.
     * @param destRequisite идентификатор реквизитов аккаунта получателя.
     * @param amount сумма перевода.
     * @return возвращает true в случае успешного выполнения операции перевода, иначе false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
