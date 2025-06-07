package org.yroqwooz.evenchecker;

public class NumberAnalyzer {
    public static boolean isEven(int num) {
        return num % 2 == 0 && num != 0;
    }

    public static boolean isDivideBy3(int num) {
        return num % 3 == 0 && num != 0;
    }

    public static boolean isDivideBy5(int num) {
        return num % 5 == 0 && num != 0;
    }

    public static boolean isDivideBy10(int num) {
        return num % 10 == 0 && num != 0;
    }
}
