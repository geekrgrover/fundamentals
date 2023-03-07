


/**
* psuedo code
*/
class MergeSort {
  public static void main(String[] args) {
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
      return list;
    }
    int mid = (s + e)/2;
    doSortAndMerge(s, mid, list);
    doSortAndMerge(mid+1, e, list);
    int[] aux = new int[(e - s)+1];

    int k = mid+1;
    int i = s;
    int j = mid+1;
    int auxI = 0;
    while(i <= mid && j <= e ) {
       if(list[i] < list[j]) {
        aux[auxI] = list[i];
        i++;
      }
      if(list[i] >= list[j]) {
        aux[auxI] = list[k];
        j++;
      }
     auxI++;
    }
  if(i <= mid) {
    int xi = auxI;
    for(int d = i; d<=mid; d++) {
     aux[xi] = list[d];
     xi++;
    }
  }
    
    if(j <= e) {
      int xi = auxI;
      for(int d = i; d<=e; d++) {
        aux[xi] = list[d];
        xi++;     
      }
    }    
    return aux;
  }
}
/**
*Working code
*/
class WorkingSolution {
  public static void main(String[] args) {
    int[] list = new int[] {2,8,3,6,10,5};
    int[] sorted = mergeSort(list, list.length);
    for (int i: sorted) {
      System.out.println(i);
    }
  }

  public static int[] mergeSort(int[] list, int n) {
    if(n <=1) {
      return list;
    }
    int mid = n/2;
    int[] l = new int[mid];
    int[] r = new int[n-mid];
    for(int i=0; i< mid; i++) 
    {
      l[i] = list[i];
    }
    for(int j=mid; j< n; j++) 
    {
      r[j-mid] = list[j];
    }
    mergeSort(l, mid);
    mergeSort(r, n-mid);
    merge(list, l, r, mid, n-mid );
    return list;
  }

  private static int[] merge(int[] list, int[] lr, int[] rr, int l, int r) {

    int i =0 , j = 0, k = 0;
    while(i < l && j < r) {
      if(lr[i] <= rr[j]) {
        list[k++] = lr[i++];
      }
      else {
        list[k++] = rr[j++];
      }
    } 
    while (i < l)
    list[k++] = lr[i++];
  

    while(j < r) {
      list[k++] = rr[j++];
  }
  return list;
  }
}

