package arrays;

import java.util.ArrayList;

public class N16_LargestSubArray {

//    Given an integer array nums, find the
//    subarray
//    with the largest sum, and return its sum.

//    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//    Output: 6
//    Explanation: The subarray [4,-1,2,1] has the largest sum 6.

    public static int maxSubArray(int[] nums, ArrayList < Integer > subarray) {
        int max_sum = Integer.MIN_VALUE;
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        for (int i = 0; i <= n - 1; i++) {
            for (int j = i; j <= n - 1; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++)
                    sum = sum + nums[k];
                if (sum > max_sum) {
                    subarray.clear();
                    max_sum = sum;
                    subarray.add(i);
                    subarray.add(j);
                }
            }
        }
        return max_sum;
    }


    //KAdane's Algorithm
    static int maxSubArraySumOpt(int a[])
    {
        int size = a.length;
        int max_sum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum = sum + a[i];
            if (max_sum < sum)
                max_sum = sum;
            if (sum < 0)
                sum = 0;
        }
        return max_sum;
    }

    public static int maxSubArraySumOptPrac(int[] arr){
        int size=arr.length;
        int maxTillHere=Integer.MIN_VALUE;
        int maxInThisWindow=0;

        for(int i=0; i<size;i++){
            maxInThisWindow=maxInThisWindow+arr[i];
            if(maxInThisWindow>maxTillHere){
                maxTillHere=maxInThisWindow;
            }
            if (maxInThisWindow<0) {
                maxInThisWindow = 0;
            }
        }
        return maxTillHere;
    }


    public static void main(String args[]) {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        ArrayList < Integer > subarray = new ArrayList< >();
        int lon = maxSubArraySumOpt(arr);
        System.out.println(lon);
    }
}
