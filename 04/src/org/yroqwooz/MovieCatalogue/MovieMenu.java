package org.yroqwooz.MovieCatalogue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MovieMenu {
    private static MovieLibrary lib;
    private static Scanner sc;
    private static final Map<String, Runnable> actions = new HashMap<>();

    public static void menu(MovieLibrary movieLibrary, Scanner scanner) {
        lib = movieLibrary;
        sc = scanner;

        initActions();

        boolean exit = false;
        while (!exit) {
            printMenu();
            String choice = sc.nextLine().trim().toLowerCase();
            if (choice.equals("q")) {
                exit = true;
            } else {
                actions.getOrDefault(choice, MovieMenu::handleInvalidChoice).run();
            }
        }
    }

    private static void printMenu() {
        System.out.println("""
                     1 - Показать все фильмы
                     2 - Добавить фильм
                     3 - Фильмы по режиссёру...
                     4 - Классические фильмы
                     5 - Фильмы с высоким рейтингом
                     6 - Ипортировать из JSON
                     7 - Экспортировать в JSON
                     8 - Отсортировать по годам
                     9 - Фильмы до года...
                    10 = Фильмы в промежутке лет...
                    11 - Фильмы конкретного года...
                    12 - Фильмы по названию...
                    
                    q - Выход""");
    }

    private static void initActions() {
        actions.put("2746", MovieMenu::handleSeedMovies);
        actions.put("1", MovieMenu::handleShowAllMovies);
        actions.put("2", MovieMenu::handleAddMovie);
        actions.put("3", MovieMenu::handleSearchByDirector);
        actions.put("4", MovieMenu::handleShowClassics);
        actions.put("5", MovieMenu::handleHighRated);
        actions.put("6", MovieMenu::handleImportFromJson);
        actions.put("7", MovieMenu::handleExportToJson);
        actions.put("8", MovieMenu::handleSortedByYear);
        actions.put("9", MovieMenu::handleMoviesAfterYear);
        actions.put("10", MovieMenu::handleMoviesBetweenYears);
        actions.put("11", MovieMenu::handleMoviesByYear);
        actions.put("12", MovieMenu::handleMovieByTitle);
        actions.put("13", MovieMenu::handleShowFavorite);
        actions.put("14", MovieMenu::handleToggleFavoriteByTitle);
    }

    private static void handleSeedMovies() {
        lib.seedMovies();
    }

    private static void handleShowAllMovies() {
        printList(lib.getAllMovies());
    }

    private static void handleAddMovie() {
        lib.addMovie(new Movie(sc));
    }

    private static void handleSearchByDirector() {
        String director = UserInput.inputString(sc, "Введите режиссёра: ");

        printList(lib.getMoviesByDirector(director));
    }

    private static void handleShowClassics() {
        printList(lib.getClassics());
    }

    private static void handleHighRated() {
        double rating = UserInput.inputDouble(sc, "Введите нижний рейтинг");
        printList(lib.getHighRatedMovies(rating));
    }

    private static void handleExportToJson() {
        String path = UserInput.inputString(sc, "Введите путь до json-файла для записи: ");
        JsonManager.writeJson(path, lib.getAllMovies());
    }

    private static void handleImportFromJson() {
        List<Movie> list = JsonManager.readJson(UserInput.inputString(sc, "Введите путь до json-файла для чтения: "));
        if (list != null) {
            lib.addMovies(list);
        } else {
            System.out.println("Ошибка: не удалось загрузить фильмы из JSON.");
        }
    }

    private static void handleSortedByYear() {
        printList(lib.getMoviesSortedByYear());
    }

    private static void handleMoviesAfterYear() {
        printList(lib.getMoviesAfterYear(UserInput.inputYear(sc)));
    }

    private static void handleMoviesBetweenYears() {
        int[] year = UserInput.inputYearRange(sc);
        List<Movie> list = lib.getMoviesByYearRange(year);
        printList(list);
    }

    private static void handleMoviesByYear() {
        printList(lib.getMoviesByYear(UserInput.inputYear(sc)));
    }

    private static void handleMovieByTitle() {
        printList(lib.getMoviesByTitle(UserInput.inputString(sc, "Введите название фильма: ")));
    }

    private static void handleShowFavorite() {
        printList(lib.getFavoriteMovies());
    }

    private static void handleToggleFavoriteByTitle() {
        
    }

    private static void handleInvalidChoice() {
        System.out.println("Неверный ввод. Попробуйте снова.");
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
