package org.yroqwooz.arraying;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayBuilder {
    private final int size;
    private final int[] arr;
    private int max;
    private int min;
    private int sum;
    private double mean;

    public ArrayBuilder(Scanner sc) {
        System.out.println("Введите размер массива:");
        size = readArraySize(sc);
        arr = new int[size];
        System.out.println("Введите элементы массива:");
        fillArray(sc);
    }

    private void fillArray(Scanner sc) {
        for (int i = 0; i < this.size; i++) {
            arr[i] = readInt(sc);
            if (i == 0) {
                max = arr[i];
                min = arr[i];
            }
            if (max < arr[i]) { max = arr[i]; }
            if (min > arr[i]) { min = arr[i]; }
            sum += arr[i];
        }
        mean = ((double) sum) / size;
    }

    private static int readInt(Scanner sc) {
        int num = 0;
        boolean valid = false;
        while (!valid) {
            try {
                num = sc.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Введите число");
                sc.next();
            }
        }
        return num;
    }

    private static int readArraySize(Scanner sc) {
        int size = 0;
        boolean valid = false;
        while (!valid) {
            size = readInt(sc);
            if (size > 1) {
                valid = true;
            } else {
                System.out.println("Размер массива должен быть больше 1");
            }
        }
        return size;
    }

    public int getSize() {
        return this.size;
    }

    public int getMax() {
        return this.max;
    }

    public int getMin() {
        return this.min;
    }

    public int getSum() {
        return this.sum;
    }

    public double getMean() {
        return this.mean;
    }

}
