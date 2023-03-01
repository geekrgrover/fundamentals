class InsertSort{
  public static void main(String[] args) {
    System.out.println("Hello world!");
    int[] list = new int[]{8, 2, 4 , 9, 3, 6 };
    list = insertionSort(list);
    for (int i=0;i<list.length; i++) {
      System.out.println(list[i]);
    }
  }


private static int[] insertionSort(int[] list) {
  System.out.println("In the insetion sort");
  if(list == null || list.length <=0 ) {
    return list;
  }
  for (int i = 0; i< list.length; i++) {
    int  temp = list[i];
    int indx = i -1;
    while(indx >= 0 && list[indx] > temp) {
        list[indx+1] = list[indx];
        indx --;
    }
    list[indx+1] = temp;
  }
  return list;
}

  
}
