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
    int[] sorted = mergeSort(list);
    for (int i: sorted) {
      System.out.println(i);
    }
  }

  public static int[] mergeSort(int[] list) {
    if(list == null || list.length <=1) {
      return list;
    }
    return doSortAndMerge(0, list.length -1, list);
  }

  private static int[] doSortAndMerge(int s, int e, int[] list) {
    if(s == e) {
      System.out.println("SINGLE Element reached");
      return list;
    }
      System.out.println("Size of array "+list.length);
    int mid = (s + e)/2;
    System.out.println(" Mid " + mid);
    doSortAndMerge(s, mid, list);
    doSortAndMerge(mid+1, e, list);
    int[] aux = new int[(e - s)+1];

    int k = mid+1;
    int i = s;
    int j = mid+1;
    int auxI = 0;
    System.out.println("Size of aux array "+aux.length);
    while(i <= mid && j <= e ) {
      System.out.println("In merge portion aux indx "+auxI);
       if(list[i] < list[j]) {
        System.out.println("adding left "+auxI);
        aux[auxI] = list[i];
        i++;
      }
      if(list[i] >= list[j]) {
        System.out.println("adding right "+auxI);
        aux[auxI] = list[k];
        j++;
      }
     auxI++;
    }
  if(i <= mid) {
    int xi = auxI;
    System.out.println("adding left reminder "+auxI);
    for(int d = i; d<=mid; d++) {
     aux[xi] = list[d];
     xi++;
    }
  }
    
    if(j <= e) {
      int xi = auxI;
      System.out.println("adding right reminder "+auxI);
      for(int d = i; d<=e; d++) {
        aux[xi] = list[d];
        xi++;     
      }
    }    
    return aux;
  }
}
