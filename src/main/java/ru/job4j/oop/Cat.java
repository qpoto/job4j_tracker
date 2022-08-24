package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void show() {
        System.out.println(this.name + " " + this.food);
    }

    public void givNik(String nik) {
        this.name = nik;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        System.out.println("The cat's name and what he ate");
        Cat gav = new Cat();
        gav.givNik("Gav");
        gav.eat("kotleta");
        gav.show();
        System.out.println("The cat's name and what he ate");
        Cat black = new Cat();
        black.givNik("Black");
        black.eat("fish");
        black.show();
    }
}
