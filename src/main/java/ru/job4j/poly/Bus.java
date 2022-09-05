package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void run() {

    }

    @Override
    public void numberOfPassengers(int count) {

    }

    @Override
    public int oilPrice(int numberOfLiters) {
        int pricePerLitre = 52;
        return numberOfLiters * pricePerLitre;
    }
}
