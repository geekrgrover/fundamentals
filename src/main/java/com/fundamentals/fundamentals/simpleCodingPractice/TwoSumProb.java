package com.fundamentals.fundamentals.simpleCodingPractice;

import java.util.Arrays;

class TwoSumProb {
    public int[] twoSum(int[] nums, int target) {
        if(nums!= null && nums.length >= 2)
        {
            int[] targetArray = new int[2];
            int a = 0; 
            int b = 0;
            int storageIndex = 0;
            for(int i = 0; i < nums.length-1; i++)
            {
                for(int j = i+1; j<nums.length; j++)
                { 
                     a = nums[i];  b = nums[j];
                
                    if((a + b) == target)
                     {
                        if(targetArray.length >= storageIndex+2)
                        {
                            targetArray[0] = i; targetArray[1]= j;   
                        } else {
                            targetArray = Arrays.copyOf(targetArray, targetArray.length+2);
                        }
                            storageIndex+=2;

                           
                        }
                }
            }
            return   targetArray;
        }
        return null;
    }
}
