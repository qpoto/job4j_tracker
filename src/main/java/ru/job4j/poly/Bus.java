package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void run() {
        System.out.println("Автобус начал движение");
    }

    @Override
    public void numberOfPassengers(int count) {
        System.out.println("Количество пассажиров: " + count);
    }

    @Override
    public int oilPrice(int numberOfLiters) {
        int pricePerLitre = 52;
        return numberOfLiters * pricePerLitre;
    }
}
