package DP;

import java.util.Arrays;

public class N10_MinimumAbsoluteSumDifference {

    /**
     * We are given an array ‘ARR’ with N positive integers. We need to partition the array into two subsets such that the absolute difference of the sum of elements of the subsets is minimum.
     *
     * We need to return only the minimum absolute difference of the sum of elements of the two partitions.
     *
     *
     * Our work is very simple, using the last row of the dp array, we will first find which all S1 values are valid.
     * Using the valid S1 values, we will find S2 (totSum – S1).
     * From this S1 and S2, we will find their absolute difference.
     * We will return the minimum value of this absolute difference as our answer.
     *
     * Create a dp array of size [n][totSum+1]. The size of the input array is ‘n’, so the index will always lie between ‘0’ and ‘n-1’.
     * The target can take any value between ‘0’ and ‘totSum’. Therefore we take the dp array as dp[n][totSum+1]
     * We initialize the dp array to -1.
     * Whenever we want to find the answer of particular parameters (say f(ind,target)), we first check whether the answer is already calculated using the dp array(i.e dp[ind][target]!= -1 ). If yes, simply return the value from the dp array.
     * If not, then we are finding the answer for the given value for the first time, we will use the recursive relation as usual but before returning from the function, we will set dp[ind][target] to the solution we get.
     * When we get the dp array, we will use its last row to find the absolute minimum difference of two partitions.
     */


    public static void main(String[] args) {
        int[] arr={1, 2, 3, 5};
        System.out.println("The minimum sum is "+minSubsetSumDifference(arr));
    }

    private static int minSubsetSumDifference(int[] arr) {
        int n=arr.length;
        int totalSum= Arrays.stream(arr).sum();
        int[][] dp=new int[n][totalSum+1];
        for(int i=0;i< dp.length;i++) Arrays.fill(dp[i], -1);

        for (int i=0;i<totalSum;i++){
            boolean dummy=subsetSumUtil(n-1, i, arr, dp);
        }

        int min=Integer.MAX_VALUE;
        for( int i=0; i<=totalSum; i++){
            if(dp[n-1][i]==1){
                int diff = Math.abs(i - (totalSum - i));
                min = Math.min(min, diff);
            }
        }
        return min;

    }

    private static boolean subsetSumUtil(int ind, int target, int[] arr, int[][] dp) {
        if (target == 0)
            return true;

        if (ind == 0)
            return arr[0] == target;

        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);

        boolean taken = false;
        if (arr[ind] <= target)
            taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);
        dp[ind][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }


}
