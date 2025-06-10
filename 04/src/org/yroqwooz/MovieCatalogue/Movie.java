package org.yroqwooz.MovieCatalogue;

import java.time.Year;
import java.util.Scanner;

public class Movie {
    private String title;
    private String director;
    private int year;
    private double score;

    public Movie(String title, String director, int year, double score) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.score = score;
    }

    public Movie(Scanner sc) {
        this.title = UserInput.inputString(sc, "Введите название фильма: ");
        this.director = UserInput.inputString(sc, "Введите режиссёра фильма: ");
        this.year = UserInput.inputInt(sc, "Введите год выпуска фильма: ");
        this.score = UserInput.inputDouble(sc, "Введите рейтинг фильма");
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Director: " + director + ", Year: " + year + ", Score: " + score;
    }

    public boolean isClassic() {
        return Year.now().getValue() - year > 25;
    }
}
