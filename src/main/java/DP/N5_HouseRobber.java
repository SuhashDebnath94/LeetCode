package DP;

import java.util.Arrays;

public class N5_HouseRobber {
//
//    Given an array of ‘N’  positive integers, we need to return the maximum sum of the subsequence such that no two elements of the subsequence are adjacent elements in the array.
//
//    Note: A subsequence of an array is a list with elements of the array where some elements are deleted ( or not deleted at all) and the elements should be in the same order in the subsequence as in the array.

    public static void main(String[] args) {
        int[] arr = {1, 2, 4};
        int[] dp=new int[4];
        Arrays.fill(dp, -1);
        System.out.println(houseRobberDP(arr,arr.length, dp));
    }

    private static int houseRobberDP(int[] arr,int n, int[] dp) {
        int ind=n-1;
        if(ind==0){
            dp[n]=arr[ind];
            return arr[0];
        }
        if(ind<0){
            return 0;
        }
        if(dp[n-1]!=-1) {
            return dp[n];
        };
        int pick=arr[ind]+houseRobberDP(arr, n-2, dp);
        int leave= 0+ houseRobberDP(arr, n-1, dp);
        dp[n]=Math.max(pick, leave);
        return dp[n];
    }


    private static int houseRobberDPTabu(int[] arr,int n, int[] dp) {
        int ind=n-1;
        if(ind==0){
            dp[n]=arr[ind];
            return arr[0];
        }
        if(ind<0){
            return 0;
        }
        if(dp[n-1]!=-1) {
            return dp[n];
        };
        for(int i= 1;i<n;i++){
            int pick=arr[ind];
            if(i>1)pick=pick+dp[n-2];
            int leave= 0+ dp[n-1];
            dp[i]=Math.max(pick, leave);
        }
        return dp[n];
    }

    private static int houseRobberDPSpaceOptimization(int[] arr,int n) {
        int ind=n-1;
        int prev = arr[0];
        int prev2= 0;
        for(int i= 1;i<n;i++){
            int pick=arr[ind];
            if(i>1)pick=pick+prev2;
            int leave= 0+ prev;
            int curi=Math.max(pick, leave);
            prev2= prev;
            prev=curi;
        }
        return prev;
    }


}
