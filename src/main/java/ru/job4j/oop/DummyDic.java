package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово " + eng;
    }

    public static void main(String[] args) {
        DummyDic dd = new DummyDic();
        String result = dd.engToRus("AFK");
        System.out.println(result);
    }
}