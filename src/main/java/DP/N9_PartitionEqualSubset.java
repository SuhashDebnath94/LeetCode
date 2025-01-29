package DP;

import java.util.Arrays;

public class N9_PartitionEqualSubset {
    /**
     * We are given an array ‘ARR’ with N positive integers.
     * We need to find if we can partition the array into two subsets such that the sum of elements of each subset is equal to the other.
     * <p>
     * Sum of elements of S1 + sum of elements of S2 = sum of elements of S.
     * Sum of elements of S1 = sum of elements of S2.
     * These two conditions imply that S1 = S2 = (S/2).
     * <p>
     * If S (sum of elements of the input array) is odd , there is no way we can divide it into two equal halves, so we can simply return false.
     * If S is even, then we need to find a subsequence in the input array whose sum is equal to S/2 because if we find one subsequence with sum S/2,
     * the remaining elements sum will be automatically S/2. So, we can partition the given array. Hence we return true.
     */

    static boolean subsetSumUtil(int ind, int target, int arr[], int[][] dp) {
        if (target == 0)
            return true;

        if (ind == 0)
            return arr[0] == target;

        if (dp[ind][target] != -1)
            return dp[ind][target] != 0;

        boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);

        boolean taken = false;
        if (arr[ind] <= target)
            taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);
        dp[ind][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }

    static boolean canPartition(int n, int[] arr) {

        int totSum = 0;

        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        if (totSum % 2 == 1) return false;

        else {
            int k = totSum / 2;
            int dp[][] = new int[n][k + 1];
            for (int row[] : dp)
                Arrays.fill(row, -1);
            return subsetSumUtil(n - 1, k, arr, dp);
        }
    }

    public static void main(String args[]) {

        int arr[] = {2, 3, 3, 3, 4, 5};
        int n = arr.length;

        if (canPartition(n, arr))
            System.out.println("The Array can be partitioned into two equal subsets");
        else
            System.out.println("The Array cannot be partitioned into two equal subsets");
    }
}
