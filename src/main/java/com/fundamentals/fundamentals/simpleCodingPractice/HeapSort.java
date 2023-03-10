package com.fundamentals.fundamentals.simpleCodingPractice;

public class HeapSort {

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        //int arr[] = {1,1,1,1,1,1,1,1,1,1,1,1};
        sortHeap(arr);
    }

    public static void sortHeap(int[] arr) {
        int length = arr.length;
        // create a binary max heap with the input
        for (int i = (length/2 - 1); i >= 0; i--) {
            heapify(arr, length, i);
        }
        // do max extraction and re-heapify
        for (int i = length - 1; i >= 0; i--) {
            // remove the current root to the farthest leaf node
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // call heapify with the heap - node where root was added
            // root index is zero because root is always at index 0, moved now from farthest left node
            heapify(arr, i, 0);
        }
        printArr(arr);
    }

    public static void heapify(int[] arr, int length, int rootIndex) {
        int leftIndex = rootIndex * 2 + 1;
        int rightIndex = rootIndex * 2 + 2;
        int largeIndex = rootIndex;

        if (leftIndex < length && arr[largeIndex] < arr[leftIndex]) {
            largeIndex = leftIndex;
        }
        if (rightIndex < length && arr[largeIndex] < arr[rightIndex]) {
            largeIndex = rightIndex;
        }
        if (rootIndex != largeIndex) {
            int swap = arr[rootIndex];
            arr[rootIndex] = arr[largeIndex];
            arr[largeIndex] = swap;
            heapify(arr, length, largeIndex);
        }
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
