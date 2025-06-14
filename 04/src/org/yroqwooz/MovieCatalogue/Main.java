package org.yroqwooz.MovieCatalogue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieLibrary lib = new MovieLibrary();
        lib.seedMovies();
        MovieMenu.menu(lib, sc);
    }
}