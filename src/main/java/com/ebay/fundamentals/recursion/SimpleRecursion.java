package com.ebay.fundamentals.recursion;

public class SimpleRecursion {
    
    private static int sum(int n) {
        int sum = 0;
        if (n >= 0) {
            
            sum = n + sum(n - 1);
            System.out.println("The value of n :" + n);
        }
        
        return sum;
        
    }
    
    public static void main(String[] args) {
        System.out.println("Invoking Sum :" + sum(10));
    }
}
