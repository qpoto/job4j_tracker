package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (!isContainsUpperCaseChar(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!isContainsLowercaseChar(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!isContainsDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!isContainsSpecialChar(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (!isNotContainsSubstring(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return "Valid";
    }

    private static boolean isContainsUpperCaseChar(String password) {
        for (Character c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isContainsLowercaseChar(String password) {
        for (Character c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isContainsDigit(String password) {
        for (Character c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isContainsSpecialChar(String password) {
        for (Character c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNotContainsSubstring(String password) {
        String[] substring = {"qwerty", "12345", "password", "admin", "user"};
        for (String s : substring) {
            if (password.toLowerCase().contains(s)) {
                return false;
            }
        }
        return true;
    }

}