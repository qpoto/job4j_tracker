package ru.job4j.oop;

public class Calculator {
    public static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int z) { // Не понимаю как реализовать данный метод//
        return z;
    }

    public static void main(String[] args) {
        int rsl = sum(1) + minus(1);
        Calculator calculator = new Calculator();
        int rsl2 = calculator.multiply(1) + calculator.divide(1);
        int rsl3 = rsl + rsl2;
        System.out.println(rsl3);
    }
}

