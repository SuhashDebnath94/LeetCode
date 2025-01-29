package DP;

import java.util.Arrays;

public class N11_CountNumberOfSubsetsWithSum {
    /**
     * We are given an array ‘ARR’ with N positive integers and an integer K.
     * We need to find the number of subsets whose sum is equal to K.
     *
     *
     * Create a dp array of size [n][k+1].
     * The size of the input array is ‘n’, so the index will always lie between ‘0’ and ‘n-1’.
     * The target can take any value between ‘0’ and ‘k’. Therefore we take the dp array as dp[n][k+1]
     * We initialize the dp array to -1.
     * Whenever we want to find the answer of particular parameters (say f(ind,target)), we first check whether the answer is already calculated using the dp array(i.e dp[ind][target]!= -1 ). If yes, simply return the value from the dp array.
     * If not, then we are finding the answer for the given value for the first time, we will use the recursive relation as usual but before returning from the function, we will set dp[ind][target] to the solution we get.
     */

    public static void main(String args[]) {

        int arr[] = {1,2,2,3};
        int k=3;

        System.out.println("The number of subsets found are "+findWays(arr,k));
    }

    private static int findWays(int[] arr, int k) {
        int n = arr.length;
        int dp[][]=new int[n][k+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        return findWaysUtil(n-1,k,arr,dp);
    }

    private static int findWaysUtil(int ind, int target, int[] arr,int[][] dp) {
        if (target == 0)
            return 1;

        if (ind == 0){
           return arr[0] == target ?  1: 0;
        };

        if (dp[ind][target] != -1)
            return dp[ind][target];

        int notTaken = findWaysUtil(ind - 1, target, arr, dp);

        int taken = 0;
        if (arr[ind] <= target)
            taken = findWaysUtil(ind - 1, target - arr[ind], arr, dp);
        return dp[ind][target] = notTaken + taken;
    }
}
