package org.yroqwooz.arraying;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayBuilder ab = new ArrayBuilder(sc);

        System.out.println("Размер массива: " + ab.getSize());
        System.out.println("Максимальное значение: " + ab.getMax());
        System.out.println("Минимальное значение: " + ab.getMin());
        System.out.println("Сумма элементов массива: " + ab.getSum());
        System.out.println("Среднее арифметическое элементов массива: " + ab.getMean());

    }
}