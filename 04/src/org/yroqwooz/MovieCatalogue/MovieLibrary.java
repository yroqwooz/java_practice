package org.yroqwooz.MovieCatalogue;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class MovieLibrary {
    private List<Movie> movieList;

    public MovieLibrary() {
        movieList = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public List<Movie> getAllMovies() {
        return movieList;
    }

    public List<Movie> getMoviesByDirector(String director) {
        List<Movie> list = new ArrayList<Movie>();
        for (Movie movie : movieList) {
            if (movie.getDirector().equalsIgnoreCase(director)) {
                list.add(movie);
            }
        }
        return list;
    }

    public List<Movie> getMoviesAfterYear(int year) {
        List<Movie> list = new ArrayList<Movie>();
        for (Movie movie : movieList) {
            if (movie.getYear() > year) {
                list.add(movie);
            }
        }
        return list;
    }

    public List<Movie> getClassics() {
        List<Movie> list = new ArrayList<Movie>();
        for (Movie movie : movieList) {
            if (movie.isClassic()) {
                list.add(movie);
            }
        }
        return list;
    }

    public List<Movie> getHighRatedMovies(double minScore) {
        List<Movie> list = new ArrayList<Movie>();
        for (Movie movie : movieList) {
            if (movie.getScore() > minScore) {
                list.add(movie);
            }
        }
        return list;
    }

    public List<Movie> getMoviesSortedByYear() {
        List<Movie> list = new ArrayList<Movie>(movieList);
        list.sort(Comparator.comparing(Movie::getYear));
        return list;
    }
}
