package com.fundamentals.fundamentals.simpleCodingPractice;

/**
 * https://leetcode.com/problems/get-the-maximum-score/
 * Was Asked to me in Oracle phone interview, and gave 20 minutes to finish this
 */
public class MaximumScoreProblem {
    public static void main(String[] args) {
        int[] first = new int[]{3, 5, 7, 9, 20, 25, 30, 40, 55, 56, 57, 60, 62};
        int[] second = new int[]{1, 4, 7, 11, 14, 25, 44, 47, 55, 57, 100};

        System.out.println("Max sum " + maxSum(first, second));
    }

    public static int maxSum(int[] first, int[] second) {
        int sum1 = 0, sum2 = 0, maxsum = 0, i = 0, j = 0;
        while (i < first.length && j < second.length) {
            if (first[i] == second[j]) {
                System.out.println("Equal: i: " + i + " j: " + j);
                maxsum += Math.max(sum1, sum2) + second[j];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            } else if (first[i] < second[j]) {
                System.out.println("big j incrementing smaller(i):" + j);
                sum1 += first[i++];

            } else {
                System.out.println("big i incrementing smaller(j):" + i);
                sum2 += second[j++];
            }
        }
        if (i < first.length) { // no need for this if, while alone would do: keeping for logs
            System.out.println("more i :" + i);
            while (i < first.length) {
                sum1 += first[i++];

            }
        }
        if (j < second.length) { // no need for this if, while alone would do: keeping for logs
            System.out.println("more j :" + j);
            while (j < second.length) {
                sum2 += second[j++];
            }
        }
        System.out.println("Sums at the end sum1: " + sum1 + " sum2: " + sum2);
        maxsum += Math.max(sum1, sum2);
        return maxsum;
    }
}
