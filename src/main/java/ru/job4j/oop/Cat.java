package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void show() {
        System.out.println("The cat's name is " + this.name + ", and he ate a " + this.food);
    }

    public void givNik(String nik) {
        this.name = nik;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.givNik("Gav");
        gav.eat("kotleta");
        gav.show();
        Cat black = new Cat();
        black.givNik("Black");
        black.eat("fish");
        black.show();
    }
}
