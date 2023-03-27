package com.fundamentals.fundamentals.simpleCodingPractice;

/**
 * Quick sort
 * Best case time complexity - O(n(log n))
 * Worst case time complexity - O(n^2) (sorted input)
 * space complexity - O(log(n))
 * An In Place algorithm
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] list = new int[]{4, 2, 8, 7, 1, 3, 5, 6};
        //int[] list = new int[]{1, 1, 1, 1, 1};

        qSort(list, 0, list.length - 1);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    public static void qSort(int[] list, int start, int end) {
        /**
         * Leaf node condition. No work needs to be done for this sub-array
         */
        if (start >= end) {
            return;
        }
        /**
         * Intermittant node condition where work happens.
         * The 'if clause' can be omitted as log as leaf node condition is specified and vice versa
         */
        if (start < end) {
            int index = qSortHelper(list, start, end); // The upfront partitioning
            //recursion - The solving part
            qSort(list, start, index - 1);
            qSort(list, index + 1, end);
        }
    }

    /**
     * Implementation of In-Place partitioning AKA Lumuto's partitioning.
     * Helper function will be called up-front to get the work (sorting) done upfront.
     * Merging will happen trivially as the sorting gets complete.
     *
     * @param list
     * @param start
     * @param end
     * @return
     */
    public static int qSortHelper(int[] list, int start, int end) {
        int smaller = start;
        for (int bigger = start + 1; bigger <= end; bigger++) {
            if (list[bigger] < list[start]) {
                smaller++;
                swap(smaller, bigger, list);
            }
        }
        /** TIP: Here start is always the pivot. Ideally pivot can be picked arbitrarily using
         * randomization on array indices and then swapped that with the 'start' index.
         * This can save the algorithm from predictability and provides protection from getting used against
         * worst case data.
         */
        // Swap pivot with the left pointer to keep smaller values to the left of pivot and bigger to the right
        swap(start, smaller, list);
        // return the original position of the pivot
        return smaller;
    }

    /**
     * Helper function for swap.
     *
     * @param a
     * @param b
     * @param list
     */
    private static void swap(int a, int b, int[] list) {
        int temp = 0;
        temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
}
