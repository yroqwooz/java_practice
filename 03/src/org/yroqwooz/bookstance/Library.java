package org.yroqwooz.bookstance;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> list = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                list.add(book);
            }
        }
        return list;
    }

    public List<Book> getBookOlderThan(int year) {
        List<Book> list = new ArrayList<Book>();
        for (Book book : books) {
            if (book.isOlder(year)) {
                list.add(book);
            }
        }
        return list;
    }
}
