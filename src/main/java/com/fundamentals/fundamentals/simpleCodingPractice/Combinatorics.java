package com.fundamentals.fundamentals.simpleCodingPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combinatorics {


    static long addNumbers(long a, long b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a;
        a = in.nextInt();
        long b;
        b = in.nextInt();
        long sum;

        sum = addNumbers(a, b);
        System.out.println("Sum - " + sum);
        System.out.println("fact - " + factorial(sum));
        System.out.println("itfact - " + itFactorial(sum));
        System.out.println("exponent - " + exponent(a, b));
        System.out.println("exponentOfTwo - " + exponentOfTwo(a));
        System.out.println("exponentOfN - " + exponentOfN(a, b, 0));
        combinatorials(5);
    }

    public static long factorial(long number) {
        if (number == 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }

    public static long itFactorial(long number) {
        long fact = 1;
        //    for(int i = 1; i <= number; i ++) {
        //        System.out.println(" prod * i : "+fact +" * "+ i);
        //        fact = fact * i;
        //     }
        while (number >= 1) {
            fact = fact * number;
            number--;
        }
        return fact;
    }

    public static long exponent(long n, long k) {
        if (n == 0) {
            return 0;
        }
        //    if(k == 0) {
        //        return 1;
        //    }
        if (k == 1) {
            return n;
        }
        return n * exponent(n, k - 1);

    }

    public static long exponentOfTwo(long n) {
        {
            if (n == 0) {
                return 1;
            }
            return 2 * exponentOfTwo(n - 1);
        }

    }

    // logn time complexity implementation
    public static long exponentOfN(long n, long k, long result) {
        if (result < 1) {
            result = 1;
        }
        if (k % 2 == 0) {
            result = result * exponent(n, k / 2);
            result = result * result;
        } else {
            long k1 = exponent(n, 1);
            result = k1 * exponentOfN(n, k - 1, 1);
        }
        return result;
    }

    public static void combinatorials(int n) {
        Object[] result = combHelperRecurse(n);
        for (int i = 0; i < result.length; i++) {
            System.out.println("REC" + result[i]);
        }
        Object[]  resultItr = combHelperItr(n);
        for (int i = 0; i < resultItr.length; i++) {
            System.out.println("ITR :" + resultItr[i]);
        }
        combHelperRecurseDFS("", n);
    }
    // top-heavy. workers at n will do work ~ n/2, bottom will do only one unit of it
    private static Object[] combHelperRecurse(int n) {
        if (n == 1) {
            return new String[]{"0", "1"};
        }
        Object[] previous = combHelperRecurse(n - 1);
        ArrayList<String> result = new ArrayList<String>();
        // to append 0 and 1 to the results of n-1'th steps
        for (Object i : previous) {
            result.add(i + "0");
            result.add(i + "1");
        }
        return result.toArray();
    }
    // top down. worker at top only does a unit of work and solution of n-1 is being extended to n with each iteration
    private static Object[] combHelperItr(int n) {
        // 0'th step
        Object[] result = new Object[]{"0", "1"};
        for (int i = 1; i <= n - 1; i++) { //  step 1 to n-1
            List<Object> newResult = new ArrayList<>();
            for (Object str : result) { // n'th step
                newResult.add(str + "0");
                newResult.add(str + "1");
            }
            result = newResult.toArray();
        }
        return result;
    }
    private static void combHelperRecurseDFS(String slate, int n) {
        if(n == 0) {
            System.out.println("DFS : "+slate);
        }
        else {
            combHelperRecurseDFS(slate+"0", n-1);
            combHelperRecurseDFS(slate+"1", n-1);
        }
    }
}




