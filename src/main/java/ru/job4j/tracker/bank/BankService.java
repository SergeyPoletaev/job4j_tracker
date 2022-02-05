package ru.job4j.tracker.bank;

import java.util.*;

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
     *
     * @param user пользователь, который добавляется в коллекцию.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет аккаунт к существующему пользователю.
     *
     * @param passport идентификатор паспорта пользователя.
     * @param account  аккаунт, который добавляется пользователю.
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Метод осуществляет поиск пользователя по паспортным данным.
     *
     * @param passport идентификатор паспорта пользователя.
     * @return при успешном поиске возвращает Optional найденного пользователя иначе пустой Optional.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(u -> passport.equals(u.getPassport()))
                .findFirst();
    }

    /**
     * Метод осуществляет поиск аккаунта по паспортным данным пользователя и реквизитам аккаунта,
     * связанного с этим пользователем.
     *
     * @param passport  идентификатор паспорта пользователя.
     * @param requisite идентификатор реквизитов аккаунта.
     * @return при успешном поиске возвращает Optional найденного аккаунта иначе пустой Optional.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            rsl = users.get(user.get()).stream()
                    .filter(a -> requisite.equals(a.getRequisite()))
                    .findFirst();
        }
        return rsl;
    }

    /**
     * Метод осуществляет перевод денег с одного аккаунта на другой.
     *
     * @param srcPassport   идентификатор паспорта источника.
     * @param srcRequisite  идентификатор реквизитов аккаунта источника.
     * @param destPassport  идентификатор паспорта получателя.
     * @param destRequisite идентификатор реквизитов аккаунта получателя.
     * @param amount        сумма перевода.
     * @return возвращает true в случае успешного выполнения операции перевода, иначе false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent() && srcAccount.get().getBalance() >= amount) {
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
