package com.fundamentals.fundamentals.simpleCodingPractice;

public class HeapSort {

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7, -1, 88, 0, 11, -7};
        sort(arr);


    }

    /**
     * Heap sort
     *
     * @param arr Input
     */
    public static void sort(int[] arr) {
        int length = arr.length;
        // sort
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, length, i);
        }
        /** max extract and re-heapify once max is extracted,
         this time with array size one less */
        for (int i = length - 1; i >= 0; i--) {
            // swapping current root at index 0 with the left most leaf node - last element of the array
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            /** heapify again with the array of reduced length
             ( extracted roots added at the end of the array are not included )*/
            heapify(arr, i, 0);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * Simple logic - if the largest value is not at the helm, replace helm with largest child.
     * Repeat the operation for the whole tree
     *
     * @param arr
     * @param length
     * @param rootIndex
     */
    public static void heapify(int[] arr, int length, int rootIndex) {
        int left = rootIndex * 2 + 1;
        int right = rootIndex * 2 + 2;
        int largestIndex = rootIndex;

        if (left < length && arr[largestIndex] < arr[left]) {
            largestIndex = left;
        }
        if (right < length && arr[largestIndex] < arr[right]) {
            largestIndex = right;
        }
        if (rootIndex != largestIndex) {
            int temp = arr[rootIndex];
            arr[rootIndex] = arr[largestIndex];
            arr[largestIndex] = temp;
            // recursively heapify subtree if affected
            heapify(arr, length, largestIndex);
        }

    }
}
