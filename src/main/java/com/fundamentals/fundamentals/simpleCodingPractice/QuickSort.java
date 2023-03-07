package com.fundamentals.fundamentals.simpleCodingPractice;

public class QuickSort {

    public static void main(String[] args) {
        int[] list = new int[]{4, 2, 8, 7, 1, 3, 5, 6};
        qSort(list, 0, list.length - 1);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    public static void qSort(int[] list, int start, int end) {
        if (start < end) {
            int index = qSortHelper(list, start, end);
            qSort(list, start, index - 1);
            qSort(list, index + 1, end);
        }
    }

    public static int qSortHelper(int[] list, int start, int end) {
        int smaller = start;
        for (int bigger = start + 1; bigger <= end; bigger++) {
            if (list[bigger] < list[start]) {
                smaller++;
                swap(smaller, bigger, list);
            }
        }
        swap(start, smaller, list);
        return smaller;
    }

    private static void swap(int a, int b, int[] list) {
        int temp = 0;
        temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
}
