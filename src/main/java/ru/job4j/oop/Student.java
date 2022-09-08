package ru.job4j.oop;

public class Student {
    public void music(String lyrics) {
        System.out.println("I can sign a song : " + lyrics);
    }

    public static void main(String[] args) {
        Student petya = new Student();
        String song = "Будь как дома путник, я ни в чем не откажу!";
        petya.music(song);
    }
}
