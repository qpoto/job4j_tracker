package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code", 100);
        Book job4j = new Book("Курс Петра", 200);
        Book jungleBook = new Book("The Jungle Book", 300);
        Book musketeers = new Book("Три Мушкетера", 400);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = job4j;
        books[2] = jungleBook;
        books[3] = musketeers;
        for (int i = 0; i < books.length; i++) {
            Book pr = books[i];
            System.out.println("Книга называется " + pr.getName() + ", в ней " + pr.getNumberOfPages() + " страниц");
        }
        System.out.println();
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            Book pr = books[i];
            System.out.println("Книга называется " + pr.getName() + ", в ней " + pr.getNumberOfPages() + " страниц");
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            Book pr = books[i];
            if ("Clean Code".equals(pr.getName())) {
                System.out.println("Книга называется " + pr.getName() + ", в ней " + pr.getNumberOfPages() + " страниц");
            }
        }
    }
}
