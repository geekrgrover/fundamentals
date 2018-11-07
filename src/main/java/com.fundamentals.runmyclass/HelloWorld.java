package com.fundamentals.runmyclass;

public class HelloWorld {


    public static void main(String[] args)
    {
        System.out.println("Hello World");
        System.out.println("method invoked -:"+testInvoke());
    }

    private static String testInvoke()
    {
        return "returned from method";
    }
}
