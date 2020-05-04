class Solution {
    public int[] sortArray(int[] nums) {
        if(nums == null) {
            return null;
        }
        if(nums.length == 0 || nums.length ==1) {
            return nums;
        }
       //return selectionSort(nums, nums.length);
        return insertionSort(nums);
        
        
    }
    // Recursive function to sort an array using 
    // insertion sort 
    private int[] selectionSort(int arr[], int n) 
    { 
        // Base case 
        if (n <= 1) 
            return arr; 
       
        // Sort first n-1 elements 
        selectionSort( arr, n-1 ); 
       
        // Insert last element at its correct position 
        // in sorted array. 
        int temp = arr[n-1]; 
        int j = n-2; 
       
        /* Move elements of arr[0..i-1], that are 
          greater than key, to one position ahead 
          of their current position */
        while (j >= 0 && arr[j] > temp) 
        { 
            arr[j+1] = arr[j]; 
            j--; 
        } 
        arr[j+1] = temp; 
        return arr;
    } 
    
    //create a loop that iterates from left to right
    //take the right most element in the array as temp, whch will shift to left as the outer loop moves frm left to right
    //when take the element left to temp and compare to all elemets on its left
        //if elemet being compared is small, keep moving
        //if a element greater the element being compared is reached, shift the element to the right and write temp in the
        // orignal position  of the greater element
    //repeat the process till outer loop is completed 
    
    private int[] insertionSort(int[] arr) {
        
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
        return arr;
    }
}



