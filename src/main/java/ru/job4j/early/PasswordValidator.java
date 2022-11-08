package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (!password.contains(password.toUpperCase())) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!password.contains(password.toLowerCase())) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        return "password - ok";
    }
}
