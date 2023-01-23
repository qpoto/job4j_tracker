package ru.job4j.bank;


import java.util.*;

/**
 * Главный сервис
 * @author Станислав Кондратьев
 * @version 1.0
 */
public class BankService {
    /**
     * поле содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод должен добавить пользователя в систему
     * По умолчанию к этому user нужно добавить пустой список - new ArrayList<Account>().
     * В методе должна быть проверка, что такого пользователя еще нет в системе. Если он есть, то нового добавлять не надо
     * @param user метод принимает один параметр: пользователя, т.е. объект класса User.
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * метод, который позволит удалить пользователя из системы
     * Самым важным параметром для пользователя является его паспорт,
     * этот параметр его уникально идентифицирует.
     * Именно на значении мы будем базировать удаление.
     * К тому же, согласно переопределенному equals и hashcode у User, их сравнение происходит по полю passport.
     * Используйте эту важную особенность.
     * Для удаления Вам понадобится метод remove по ключу.
     * Для того, чтобы вернуть boolean используйте возвращаемое значение указанного метода.
     * @param passport Номер паспарто пользователя
     * @return возвращеает true если пользователь удален
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * метод должен добавить новый счет к пользователю
     * Первоначально пользователя нужно найти по паспорту. Для этого нужно использовать метод findByPassport
     * После этого мы получим список всех счетов пользователя и добавим новый счет к ним.
     * В этом методе должна быть проверка, что такого счета у пользователя еще нет.
     * @param passport номер паспорта пользователя
     * @param account номер банковского счета
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
        List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * метод ищет пользователя по номеру паспорта
     * @param passport номер паспорта пользователя
     * @return Возвращает найденного пользовтеля
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * метод ищет счет пользователя по реквизитам:
     * Сначала нужно найти пользователя по паспорту с помощью метода findByPassport.
     * Потом получить список счетов этого пользователя и в нем найти нужный счет.
     * Поскольку метод findByPassport может вернуть null, то прежде чем получать список аккаунтов,
     * требуется проверить что метод findByPassport вернул отличное от null значение.
     * @param passport Номер паспорта
     * @param requisite Реквизиты счета
     * @return Возвращает Счет
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            for (Account account : accountList) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }

        }
        return null;
    }

    /**
     * метод предназначен для перечисления денег с одного счёта на другой счёт.
     * Если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят),
     * то метод должен вернуть false.
     * @param srcPassport паспорт пользователя
     * @param srcRequisite реквизиты пользователя
     * @param destPassport номер папсорта пользователя
     * @param destRequisite реквизиты пользователя
     * @param amount сумма перечисления
     * @return возвращает true если деньги переведены
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account sourceAccount = findByRequisite(srcPassport, srcRequisite);
        Account destinationAccount = findByRequisite(destPassport, destRequisite);
        if (sourceAccount != null && destinationAccount != null && amount <= sourceAccount.getBalance()) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}