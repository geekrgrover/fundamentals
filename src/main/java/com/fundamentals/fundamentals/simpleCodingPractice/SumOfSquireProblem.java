package com.fundamentals.fundamentals.simpleCodingPractice;

import java.util.Scanner;

public class SumOfSquireProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputSize = scanner.nextInt();
        //System.out.println("The int input " + inputSize);
        int[] intArray = new int[inputSize];
        for (int i = 0; i < inputSize; i++) {
            intArray[i] = scanner.nextInt();
        }
        int sum = 0;
        System.out.println("The length of array " + intArray.length);
        for (int i = 0; i < inputSize; i++) {
            sum += intArray[i] * intArray[i];
            System.out.println("The current value of sum " + sum);
        }
        System.out.println("The final sum: " + sum);
    }
}
