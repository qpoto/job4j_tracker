package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error(Boolean active, int status, String message) {
            this.active = active;
            this.status = status;
            this.message = message;
    }

    public Error() {

    }

    public void printError() {
        System.out.println("Active " + active);
        System.out.println("Status " + status);
        System.out.println("Message " + message);
    }

    public static void main(String[] args) {
        Error error = new Error(true, 1, "И раз");
        error.printError();
        Error error1 = new Error(false, 2, "И два");
        error1.printError();
        Error error2 = new Error();
        error2.printError();
    }
}
