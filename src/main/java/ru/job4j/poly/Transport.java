package ru.job4j.poly;

public interface Transport {
    void run();

    void numberOfPassengers(int count);

    int oilPrice(int numberOfLiters);
}
