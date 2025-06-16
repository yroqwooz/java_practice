package org.yroqwooz.MovieCatalogue;



import java.time.Year;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Movie {
    private int id;
    private String title;
    private String director;
    private int year;
    private double score;
    private boolean favorite;

    private static int counter = 1;

    public Movie() {}

    public Movie(String title, String director, int year, double score) {
        this.id = counter++;
        this.title = title;
        this.director = director;
        this.year = year;
        this.score = score;
        this.favorite = false;
    }

    public Movie(Scanner sc) {
        this.id = counter++;
        this.title = UserInput.inputString(sc, "Введите название фильма: ");
        this.director = UserInput.inputString(sc, "Введите режиссёра фильма: ");
        this.year = UserInput.inputInt(sc, "Введите год выпуска фильма: ");
        this.score = UserInput.inputDouble(sc, "Введите рейтинг фильма");
        this.favorite = false;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return this.id;
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

    public void setFavorite(boolean state) {
        this.favorite = state;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Director: " + director + ", Year: " + year + ", Score: " + score + ", ID: " + id;
    }

    @JsonIgnore
    public boolean isClassic() {
        return Year.now().getValue() - year > 25;
    }

    public boolean isFavourite() {
        return this.favorite;
    }
}
