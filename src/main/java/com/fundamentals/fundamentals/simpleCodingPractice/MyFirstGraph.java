package com.fundamentals.fundamentals.simpleCodingPractice;

import java.util.ArrayList;
import java.util.List;

public class MyFirstGraph {
    static List vertex;
    
    public MyFirstGraph(int size) {
        vertex = new ArrayList();
    }
    
    public static void main(String[] args) {
        testAddElement();
        
    }
    
    public static void testAddElement() {
        int[] intArray = new int[10];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i + 1;
        }
        addElement(10, intArray);
        for (int j = 0; j < vertex.size(); j++) {
            System.out.print("The vertex " + j);
            System.out.print("-->");
            ArrayList elementList = (ArrayList) vertex.get(j);
            for (int m = 0; m < elementList.size(); m++) {
                System.out.print(elementList.get(m));
                System.out.print("-->");
            }
            System.out.print("\n");
        }
    }
    
    public static void addElement( int size,  int[] elements) {
        int length = elements.length;
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                List memList = new ArrayList();
                vertex.add(i, memList);
                
            }
            for (int k = 0; k < elements.length; k++) {
                vertex.add(k, elements[k]);
                vertex.add(elements[k], k);
            }
            
        }
    }
    
}
