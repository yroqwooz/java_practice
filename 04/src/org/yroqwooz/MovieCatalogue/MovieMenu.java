package org.yroqwooz.MovieCatalogue;

import jdk.dynalink.beans.StaticClass;

import java.util.List;
import java.util.Scanner;

public class MovieMenu {
    private MovieLibrary movieLib;
    public static void menu(MovieLibrary lib, Scanner sc) {
        boolean exit = false;

        while (!exit) {
            System.out.println("""
                    1 - Показать все фильмы
                    2 - Добавить фильм
                    3 - Найти фильмы по режиссёру
                    4 - Показать классические фильмы
                    5 - Найти фильмы с высоким рейтингом
                    q - Выход
                    """);
            String choice = sc.nextLine().trim().toLowerCase();

            switch (choice) {
                case "1":
                    printList(lib.getAllMovies());
                    break;
                case "2":
                    lib.addMovie(new Movie(sc));
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "q":
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный ввод");
            }
        }
    }

    private static void printList(List<Movie> list) {
        if (list.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Movie movie : list) {
                System.out.println(movie);
            }
        }
    }

}
