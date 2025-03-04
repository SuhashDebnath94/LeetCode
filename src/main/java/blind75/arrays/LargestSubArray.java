package blind75.arrays;

import java.util.ArrayList;

public class LargestSubArray {

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


    static int maxSubArraySumOpt(int a[])
    {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
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
