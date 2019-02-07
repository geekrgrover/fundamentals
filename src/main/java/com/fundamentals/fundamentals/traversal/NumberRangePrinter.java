package com.fundamentals.fundamentals.traversal;

    
    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;
    
    public class NumberRangePrinter {
        
        public static void main(String[] args) throws Exception {
            System.out.println("Please input the number of test cases");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputTestCases = reader.readLine();
            if (Integer.parseInt(inputTestCases) > 10) {
                throw new Exception("Input cases are  more than 10,not allowd. exiting");
            }
            System.out.println("The number from system is  " + inputTestCases);
            System.out.println("Now please enter the test cases..");
            String input = reader.readLine();
            if (!input.isEmpty()) {
                StringTokenizer tokenizer = new StringTokenizer(input, " ");
                if (tokenizer.countTokens() > Integer.parseInt(inputTestCases)) {
                    throw new Exception("input more than test cases: exiting");
                }
                while(tokenizer.hasMoreElements()) {
                //for (int j = 0; j < Integer.parseInt(inputTestCases); j++) {
                    String firstNumber = tokenizer.nextToken();
                    System.out.println("The number token " + firstNumber);
                    if (firstNumber != null && firstNumber != "") {
                        Integer intVal = Integer.parseInt(firstNumber);
                        for (int i = 1; i <= intVal; i++) {
                            if (i % 3 == 0 && i % 5 == 0) {
                                System.out.println("fizzbuzz");
                            } else if (i % 3 == 0) {
                                System.out.println("fizz");
                            } else if (i % 5 == 0) {
                                System.out.println("buzz");
                            } else {
                                System.out.println("  " + i);
                            }
                        }
                    }
                }
            } else {
                System.out.println("No Input provided for test cases");
            }
            
        }
    }


