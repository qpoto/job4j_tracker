package ru.job4j.bank;
import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public boolean deleteUser(String passport) {
        users.remove(findByPassport(passport));
        return true;
    }

    public void addAccount(String passport, Account account) {
        if (!users.containsKey(findByPassport(passport))) {

        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            String psprt = user.getPassport();
            if (psprt.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}