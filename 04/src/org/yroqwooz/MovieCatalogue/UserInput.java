package org.yroqwooz.MovieCatalogue;

import java.time.Year;
import java.util.Scanner;

public class UserInput {
    private static final int MIN_YEAR = 1895;

    public static int inputInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt); // Промпт1
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное число");
            }
        }
    }

    public static int inputYear(Scanner sc) {
        int currentYear = Year.now().getValue();
        System.out.println("Введите год (от " + MIN_YEAR + " до " + currentYear + ").");
        while (true) {
            System.out.println();
            int year = inputInt(sc, "Год: ");
            if (year >= MIN_YEAR && year <= currentYear) {
                return year;
            } else {
                System.out.println("Ошибка: год должен быть между " + MIN_YEAR + " и " + currentYear + ".");
            }
        }
    }

    public static int[] inputYearRange(Scanner sc) {
        int startYear, endYear;
        do {
            System.out.print("Введите начальный и конечный год диапазона\nначальный: ");
            startYear = inputYear(sc);
            System.out.print("Конечный: ");
            endYear = inputYear(sc);
            if (startYear > endYear) {
                System.out.println("Ошибка: начальный год не может быть больше конечного.");
            }
        } while (startYear > endYear);
        return new int[] { startYear, endYear };
    }

    public static String inputString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    public static double inputDouble(Scanner sc, String prompt) {
        System.out.println(prompt);
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное число");
            }
        }
    }
}
