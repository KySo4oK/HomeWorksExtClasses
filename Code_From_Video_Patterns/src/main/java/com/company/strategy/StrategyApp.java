package com.company.strategy;

import java.util.Arrays;

public class StrategyApp {
    public static void main(String[] args) {
        StrategyClient strategy = new StrategyClient();

        int[] arr0 = {1, 3, 2, 1};
        strategy.setStrategy(new SelectionSort());
        strategy.executeStrategy(arr0);

        int[] arr1 = {11, 4, 2, 7, 8, 54};
        strategy.setStrategy(new InsertingSort());
        strategy.executeStrategy(arr1);

        int[] arr2 = {3, -8, 2, 0, 33, 1, 3, 2};
        strategy.setStrategy(new BubbleSort());
        strategy.executeStrategy(arr2);

    }
}

class StrategyClient {
    private Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] arr) {
        strategy.sort(arr);
    }
}

interface Sorting {
    void sort(int[] arr);
}

class BubbleSort implements Sorting {

    public void sort(int[] arr) {
        System.out.println("Bubble sort");
        System.out.println("Before : \t" + Arrays.toString(arr));
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("After : \t" + Arrays.toString(arr));
    }
}

class SelectionSort implements Sorting {

    public void sort(int[] arr) {
        System.out.println("Selection sort");
        System.out.println("Before : \t" + Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println("After : \t" + Arrays.toString(arr));
    }
}

class InsertingSort implements Sorting {

    public void sort(int[] arr) {
        System.out.println("Inserting sort");
        System.out.println("Before : \t" + Arrays.toString(arr));
        for (int i = 1; i >= 0; i--) {
            int index = i;
            while (index - 1 >= 0 && arr[index] < arr[index - 1]) {
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
        System.out.println("After : \t" + Arrays.toString(arr));
    }
}
