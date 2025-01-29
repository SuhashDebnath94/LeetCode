package DP;

import java.util.Arrays;

public class N12_PartitionsWithGivenDiff {
    /**
     * Count Partitions with Given Difference
     *
     * Create a dp array of size [n][k+1]. The size of the input array is ‘n’, so the index will always lie between ‘0’ and ‘n-1’. The target can take any value between ‘0’ and ‘k’. Therefore we take the dp array as dp[n][k+1]
     * We initialize the dp array to -1.
     * Whenever we want to find the answer of particular parameters (say f(ind,target)), we first check whether the answer is already calculated using the dp array(i.e dp[ind][target]!= -1 ). If yes, simply return the value from the dp array.
     * If not, then we are finding the answer for the given value for the first time, we will use the recursive relation as usual but before returning from the function, we will set dp[ind][target] to the solution we get.
     *
     */


    static int mod =(int)(Math.pow(10,9)+7);
    static int countPartitionsUtil(int ind, int target,int[] arr, int[][] dp){

        if(ind == 0){
            if(target==0 && arr[0]==0)
                return 2;
            if(target==0 || target == arr[0])
                return 1;
            return 0;
        }

        if(dp[ind][target]!=-1)
            return dp[ind][target];

        int notTaken = countPartitionsUtil(ind-1,target,arr,dp);

        int taken = 0;
        if(arr[ind]<=target)
            taken = countPartitionsUtil(ind-1,target-arr[ind],arr,dp);

        return dp[ind][target]= (notTaken + taken)%mod;
    }

    static int countPartitions(int d,int[] arr){
        int n = arr.length;
        int totSum = 0;
        for(int i=0; i<arr.length;i++){
            totSum += arr[i];
        }

        //Checking for edge cases
        if(totSum-d<0) return 0;
        if((totSum-d)%2==1) return 0;

        int s2 = (totSum-d)/2;

        int dp[][] = new int[n][s2+1];

        for(int row[]: dp)
            Arrays.fill(row,-1);

        return countPartitionsUtil(n-1,s2,arr,dp);
    }

    public static void main(String args[]) {

        int arr[] = {5,2,6,4};
        int d=3;

        System.out.println("The number of subsets found are "+countPartitions(d,arr));
    }
}
