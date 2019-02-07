package com.fundamentals.datastructures;

import java.util.EmptyStackException;

public class ArrayListImplementation {
    private final int initialSize = 10;
    
    public Object[] listArray = new Object[10];
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+  add element
    //+ add element at a specific index --> if there is element stored in the index, replace it. If not add to the stack.
    //+ find element
    //+ find element in a specific index
    //+ delete element
    //+ delete element on a specific location
    //+ internal --> double the size when the current structure is full
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    public static void main(String[] args) {
        Object[] listArray = new Object[10];
        for (int i = 0; i < 7; i++) {
            listArray[i] = i + 10;
        }
        for (int i = 0; i < listArray.length; i++) {
            System.out.println("Index :" + i + " data " + listArray[i]);
        }
        floatEmptyCells(listArray);
        for (int i = 0; i < listArray.length; i++) {
            System.out.println("Index :" + i + " data " + listArray[i]);
        }
        System.out.println("The size of the array " + listArray.length);
    }
    
    private static void floatEmptyCells(Object[] listArray) {
        if (listArray == null) throw new EmptyStackException();
        for (int i = 0; i < listArray.length; i++) {
            
            if (listArray[i] == null) {
                System.out.println("The element at " + i + " is null::starting the float ");
                for (int j = i - 1; j >= 0; ) {
                    System.out.println("Value of J :" + j + "  ::  Value of I :" + i);
                    listArray[j + 1] = listArray[j];
                    if (j == 0 && listArray[j] != null) {
                        listArray[j] = null;
                        System.out.println("Setting the " + j + "'th element to null");
                        break;
                    }
                    j--;
                }
            }
            
        }
    }
    
    public boolean isPresent(Object o) {
        boolean present = false;
        for (int i = 0; i < listArray.length; i++) {
            if (o == listArray[i]) {
                present = true;
                System.out.println("Found the element at index " + i);
                break;
            }
        }
        return present;
    }
    
    public int getIndexOf(Object o) {
        int index = 0;
        for (int i = 0; i < listArray.length; i++) {
            if (o == listArray[i]) {
                index = i;
                System.out.println("Found the element at index " + i);
                break;
            }
        }
        return index;
    }
    
    public boolean add(Object o) throws Exception {
        boolean added = false;
        checkAndIncreaseSizeDynamically();
        for (int i = 0; i < listArray.length; i++) {
            if (listArray[i] == null) {
                listArray[i] = o;
                System.out.println("Added the element " + 0 + "at index " + i);
                added = true;
                break;
            } else {
                throw new Exception("Something went wring and could not add element " + o + " to the List");
            }
        }
        
        return added;
        
    }
    
    private boolean checkAndIncreaseSizeDynamically() {
        boolean sizeDoubled = false;
        int length = listArray.length;
        if (listArray[length] != null) {
            Object[] newArray = new Object[(length * 2)];
            for (int i = 0; i < length; i++) {
                newArray[i] = listArray[i];
            }
            listArray = newArray;
            sizeDoubled = true;
        } else {
            System.out.println("The ListArray is not full. not doubling at this time");
        }
        System.out.println("The new listArray lengh " + listArray.length);
        
        return sizeDoubled;
    }
    
    public boolean add(int index, Object o) throws Exception {
        boolean added = false;
        if (index > 0 && listArray.length <= index) {
            throw new Exception("Array index is out of bound to the index provided " + index + " Cannot add element");
        }
        listArray[index] = o;
        added = true;
        
        return added;
        
    }
    
    public boolean delete(Object o) {
        boolean deleted = false;
        for (int i = 0; i < listArray.length; i++) {
            if (listArray[i] == o) {
                listArray[i] = null;
                System.out.println("Deleted the element at " + i);
                deleted = false;
                break;
            }
        }
        
        return deleted;
        
    }
    
    public boolean delete(int index) {
        boolean deleted = false;
        if (listArray.length < index) {
            if (listArray[index] != null) {
                listArray[index] = null;
            } else {
                System.out.println("The index is present but index has no data stored");
                return false;
                
            }
            return true;
        }
        
        return false;
    }
    
}
