package org.yroqwooz.evenchecker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num = 0;
        try {
            Scanner sc = new Scanner(System.in);
            num = sc.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
            System.out.println("Number: " + num);
            System.out.println("Division by  2: " + NumberAnalyzer.isEven(num));
            System.out.println("Division by  3: " + NumberAnalyzer.isDivideBy3(num));
            System.out.println("Division by  5: " + NumberAnalyzer.isDivideBy5(num));
            System.out.println("Division by 10: " + NumberAnalyzer.isDivideBy10(num));
    }
}
