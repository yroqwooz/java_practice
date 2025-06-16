package org.yroqwooz.MovieCatalogue;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class MovieLibrary {
    private final List<Movie> movieList;

    public MovieLibrary() {
        movieList = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public void addMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            movieList.add(movie);
        }
    }

    public List<Movie> getAllMovies() {
        return movieList;
    }

    public List<Movie> getMoviesByDirector(String director) {
        List<Movie> list = new ArrayList<Movie>();
        for (Movie movie : movieList) {
            if (movie.getDirector().toLowerCase().contains(director.toLowerCase())) {
                list.add(movie);
            }
        }
        return list;
    }

    public void seedMovies() {
        this.addMovie(new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9.3));
        this.addMovie(new Movie("The Godfather", "Francis Ford Coppola", 1972, 9.2));
        this.addMovie(new Movie("The Dark Knight", "Christopher Nolan", 2008, 9.0));
        this.addMovie(new Movie("Pulp Fiction", "Quentin Tarantino", 1994, 8.9));
        this.addMovie(new Movie("The Lord of the Rings: The Return of the King", "Peter Jackson", 2003, 8.9));
        this.addMovie(new Movie("Inception", "Christopher Nolan", 2010, 8.8));
        this.addMovie(new Movie("Fight Club", "David Fincher", 1999, 8.8));
        this.addMovie(new Movie("Forrest Gump", "Robert Zemeckis", 1994, 8.8));
        this.addMovie(new Movie("Interstellar", "Christopher Nolan", 2014, 8.7));
        this.addMovie(new Movie("The Matrix", "Lana Wachowski", 1999, 8.7));
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

    public List<Movie> getMoviesByTitle(String titlePart) {
        List<Movie> list = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getTitle().toLowerCase().contains(titlePart.toLowerCase())) {
                list.add(movie);
            }
        }
        return list;
    }

    public List<Movie> getMoviesByYear(int year) {
        List<Movie> list = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getYear() == year) {
                list.add(movie);
            }
        }
        return list;
    }

    public List<Movie> getMoviesByYearRange(int[] years) {
        List<Movie> list = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getYear() >= years[0] && movie.getYear() <= years[1]) {
                list.add(movie);
            }
        }
        return list;
    }
}
