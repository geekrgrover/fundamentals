package com.fundamentals.datastructures;

import java.util.ArrayList;
import java.util.Random;

public class HashTableImplementation {
    
    ArrayList<ArrayList<Data>> hashTable = new ArrayList<>(25);
    Random random = new Random(100000);
    
    public static void main(String[] args) throws Exception {
        HashTableImplementation impl = new HashTableImplementation();
        impl.testHashTable();
    }
    
    public boolean testHashTable() throws Exception {
        boolean success = false;
        for (int i = 1; i < 100; i++) {
            Data testData = new Data(i, "TestData" + i);
            this.storeData(testData);
        }
        
        success = this.retrieveDataForKey(5).key == 5 &&
                this.retrieveDataForKey(3).key == 3 &&
                this.retrieveDataForKey(7).key == 7;
        if (success) System.out.println("Test Passed");
        else System.out.println("Test failed");
        System.out.println("The hash table is " + hashTable.toString());
        printHashTable();
        return success;
    }
    
    public long storeData(Data data) throws Exception {
        int index = 0;
        
        if (data == null) {
            throw new Exception("The data to be stored is null.. cant store");
        }
        if (data.key > 0) {
            System.out.println("The key for which data is being stored is " + data.key);
            System.out.println("The hash calculated for storing this key " + data.key + " is " + getStorageIndex(calculateHash(data.key)));
            index = getStorageIndex(calculateHash(data.key));
            if (hashTable.size() == 0) {
                
                ArrayList<Data> firstList = new ArrayList<>();
                firstList.add(data);
                hashTable.add(index, firstList);
            }
//            else if (hashTable.size() <= index && hashTable.size() > 0) {
//                index = hashTable.size() - 1;
//            }
            hashTable.get(index).add(data);
            System.out.println("Adding new list with data at " + index + " Key added " + data.key);
        } else {
            throw new Exception("The key to be stored is null.. cant store");
            
        }
        
        return index;
    }
    
    public Data retrieveDataForKey(int key) {
        Data data = null;
        System.out.println("The key for which data is being retrieved is " + key);
        System.out.println("The storage index calculated for this key is " + getStorageIndex(calculateHash(key)));
        ArrayList<Data> listAtIndex = hashTable.get(getStorageIndex(calculateHash(key)));
        for (Data aData : listAtIndex) {
            if (aData.key == key) {
                data = aData;
            }
        }
        
        return data;
    }
    
    private void printHashTable() {
        for (ArrayList<Data> dataList : hashTable) {
            System.out.println("Hashtable Index " + hashTable.indexOf(dataList));
            System.out.println("........members in the index :");
            for (Data aData : dataList) {
                System.out.println(".............Key :" + aData.key + " -- Value" + aData.value);
            }
        }
    }
    
    private int getStorageIndex(long hash) {
        int index = 0;
        System.out.println("Size of hash table bfore calculating index " + hashTable.size());
        if (hashTable.size() > 0)
            index = (int) hash % hashTable.size();
        
        System.out.println("Index :" + index);
        return index;
    }
    
    private long calculateHash(long key) {
        long hashVal = 0l;
        if (key > 0) {
            hashVal = ((key + 1) * 998) % key + 2;
        }
        System.out.println("The hash value " + hashVal);
        return Math.abs(hashVal);
    }
    
    class Data {
        public String value;
        public long key;
        
        Data(long key, String value) {
            this.value = value;
            this.key = key;
        }
        
        @Override
        public String toString() {
            return "Key :" + key + " Value :" + value;
        }
        
    }
}
