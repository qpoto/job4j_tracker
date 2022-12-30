package ru.job4j.enumeration;

public class CarService {
    public static void main(String[] args) {
        Status toyota = Status.FINISHED;
        Status volvo = Status.WAITING;
        System.out.println("Статус toyota: " + toyota);
        System.out.println("Статус volvo: " + volvo);
        System.out.println();
        Order order = new Order(1, "Mercedes-Benz GLS", Status.IN_WORK);
        System.out.println("Заказ-наряд №" + order.getNumber()
                + " на автомобиль " + order.getCar()
                + ", статус ремонта: " + order.getStatus().getInfo()
                + ", подробности: " + order.getStatus().getMessage());
        System.out.println();
        Status[] statuses = Status.values();
        for (Status s : statuses) {
            System.out.println("Название статуса: " + s.name() + ", Порядковый номер статуса: " + s.ordinal());
        }
    }
}
