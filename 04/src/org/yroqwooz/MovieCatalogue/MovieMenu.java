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
                    6 - Показать фильмы(отсортировано по годам)
                    7 - Ипортировать из JSON
                    8 - Экспортировать в JSON
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
                    printList(lib.getMoviesByDirector(UserInput.inputString(sc, "Введите режиссёра")));
                    break;
                case "4":
                    printList(lib.getClassics());
                    break;
                case "5":
                    printList(lib.getHighRatedMovies(UserInput.inputDouble(sc, "Введите нижний рейтинг")));
                    break;
                case "6":
                    printList(lib.getMoviesSortedByYear());
                    break;
                case "7":
                    JsonManager.readJson(UserInput.inputString(sc, "Введите путь до json-файла для чтения"));
                    break;
                case "8":
                    JsonManager.writeJson(UserInput.inputString(sc, "Введите путь до json-файла для записи"), lib.getAllMovies());
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
