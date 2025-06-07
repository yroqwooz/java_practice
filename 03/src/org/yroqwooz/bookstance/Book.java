package org.yroqwooz.bookstance;

public class Book {
    private String title;
    private String author;
    private int year;
    private int pages;

    public Book(String title, String author, int year, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getYear() {
        return this.year;
    }

    public int getPages() {
        return this.pages;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // just for practice
        sb.append("Title: ").append(title)
          .append(", Author: ").append(author)
          .append(", Year: ").append(year)
          .append(", Pages: ").append(pages);
        return sb.toString();
    }

    public boolean isOlder(int year) {
        return this.year < year;
    }
}
