package org.yroqwooz.MovieCatalogue;

import java.util.Scanner;

public class UserInput {

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

    public static String inputString(Scanner sc, String prompt) {
        System.out.println(prompt);
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
//        return sc.nextLine().trim();
    }

}
