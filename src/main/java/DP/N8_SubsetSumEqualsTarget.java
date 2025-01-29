package DP;

import java.util.Arrays;

public class N8_SubsetSumEqualsTarget {

    //    Given an array return true if any of its subsets is equal to a target

    /**
    soln:
        1) When tehre are problems on subsets express everything in terms of index and target
    2) explore possibilities on that index

     So an index can either be part of a subsequence or not be a part of a subsequence

     f(ind, target)
     {
     if(k==0) return target;
     if(ind==0) return arr[ind]==target;

     bool not_take= f(ind-1, target)
     bool take = false;
     if(target> a[ind])
     {
        take = f( ind-1, target - a[ind])
     }
     }

     T = O(2^n)
     S = O(n)
     **/
    private static boolean subsetSumEqualsK(int[] arr,int n, int k) {
        if(k==0) return true;
        if(n==0) return arr[0]==k;

        boolean not_take= subsetSumEqualsK(arr, n-1, k);
        boolean take=false;

        if(k>=arr[n]) {
            take = subsetSumEqualsK(arr, n - 1, k - arr[n]);
        }

        return take || not_take;
    }

    /**
     * For Memoization:
     *  Assume an max target value of 10^3
     *  take DP array of 10^3+1 * 10^3+1
     *  add dp[ind][target] != -1 return dp[ind][target]
     *  add return dp[ind][target]
     *
     *
     * For Tabulation:
     *
     * 1) Go to recurrence and see the base cases
     *  if target == 0 return true
     *  hence if target is 0 what can be the possible values of index?
     *  if index==0 return true if arr[index]==target
     *  so if index is 0 then it will return true only if dp[0][arr[0]]=true;
     *
     * 2) Now the number of state will be equal to the number of nested loops.
     *
     *
     *  take DP array of dp[n][target]
     *      for (i=0 -> n-1) dp[i][0]=true;
     */
    static boolean subsetSumUtil(int ind, int target,int[] arr,int[][] dp){
        if(target==0)
            return true;

        if(ind == 0)
            return arr[0] == target;

        if(dp[ind][target]!=-1)
            return dp[ind][target]==0?false:true;

        boolean notTaken = subsetSumUtil(ind-1,target,arr,dp);

        boolean taken = false;
        if(arr[ind]<=target)
            taken = subsetSumUtil(ind-1,target-arr[ind],arr,dp);
        dp[ind][target]=notTaken||taken?1:0;
        return notTaken||taken;
    }
    static boolean subsetSumToK(int n, int k,int[] arr){

        int dp[][]=new int[n][k+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return subsetSumUtil(n-1,k,arr,dp);
    }

    public static void main(String args[]) {

        int arr[] = {1,2,3,4};
        int k=4;
        int n = arr.length;

        if(subsetSumToK(n,k,arr))
            System.out.println("Subset with given target found");
        else
            System.out.println("Subset with given target not found");
    }

    static boolean subsetSumToKTab(int n, int k,int[] arr){


        boolean dp[][]= new boolean[n][k+1];

        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }

        if(arr[0]<=k)
            dp[0][arr[0]] = true;

        for(int ind = 1; ind<n; ind++){
            for(int target= 1; target<=k; target++){

                boolean notTaken = dp[ind-1][target];

                boolean taken = false;
                if(arr[ind]<=target)
                    taken = dp[ind-1][target-arr[ind]];

                dp[ind][target]= notTaken||taken;
            }
        }

        return dp[n-1][k];
    }
}
