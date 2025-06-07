package org.yroqwooz.bookstance;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(new Book("War and Peace", "Lev Tolstoy", 1869, 1225));
        lib.addBook(new Book("Harry Potter and Prisoner of Azkaban", "Joanne Rowling", 1999, 485));
        lib.addBook(new Book("Ready Player One", "Dunno Who", 2015, 489));

        var arr1 = lib.getBooks();
        for (var book : arr1) {
            System.out.println(book);
        }
        System.out.println();
        var arr2 = lib.getBooksByAuthor("Dunno Who");
        for (var book : arr2) {
            System.out.println(book);
        }
        System.out.println();
        var arr3 = lib.getBookOlderThan(2000);
        for (var book : arr3) {
            System.out.println(book);
        }
    }
}