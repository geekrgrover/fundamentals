/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());

    for (String string : strings) {
      System.out.println(string);
    }
    int[] list = new int[] {2,8,3,6,10,5};
    //mergeSort(list);
  }

  public static int[] mergeSort(int[] list) {
    if(list == null || list.length <=1) {
      return list;
    }
    return doSortAndMerge(0, list.length -1, list);
  }

  private static int[] doSortAndMerge(int s, int e, int[] list) {
    if(list.length <=1) {
      System.out.println("SINGLE Element reached");
      return list;
    }
    int mid = (s + e)/2;
    System.out.println(" Mid ", + mid);
    doSortAndMerge(s, mid, list);
    doSortAndMerge(mid+1, e, list);
    int[] aux = new int[list.length];
    int k = mid+1;
    int i = s;
    int j = mid+1;
    int auxI = 0;

    while(i < mid && j < e ) {
      System.out.println("In merge portion");
       if(list[i] < list[j]) {
        aux[auxI] = list[i];
        s++;
        auxI++;
      }
      if(list[s] >= list[k]) {
        aux[auxI] = list[k];
        k++;
        auxI++;
      }

    }
  if(i <= mid) {
    for(int d = i; d<=mid; d++) {
     aux[auxI] = list[d];
     auxI++;
    }
  }
    
    if(j <= e) {
      for(int d = i; d<=e; d++) {
        aux[auxI] = list[d];
        auxI++;     
      }
    }    
    return list;
  }
}
