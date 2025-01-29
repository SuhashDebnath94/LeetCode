package DP;

import java.util.Arrays;

public class N3_FrogJump {

//    Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair.
//    At a time the frog can climb either one or two steps. A height[N] array is also given.
//    Whenever the frog jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference.
//    We need to return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1.

//    we need the minimum energey required to reach from 0 to n-1
//    we put every array index as an index

//    do every thing possible on that index
//    SO what can we do from each index
//    We can jump to either +1 or +2
//    left= f(index-1) + abs( arr[index]-arr[index-1])
//      right = f(index-2) + abs( arr[index]-arr[index-2])
//    min(left,right)

//        recursion tree:tree
//                    f(5)
//                    /\
//                f(4)    f(3)
//                /\         /\
//            f(3) f(2)    f(2) f(1)
//            /\      /\      /\  /\
//          f(2)f(1) f(1)f(0)

//    since tehre are overlapping sub problems we can apply memoization

//    To convert recursion to DP check which are the recurring sub problems
//  Step 1:  create a dp size of index+1
//    Step 2: Before returning add the result to DP
//    Step 3: whenever you call recursion check if dp has that value or not
//    T: is O(n)

//    Memoization:

//    int f(int ind, int[] arr, dp){
//        if(ind==0) return 0;
//    if(dp[ind] !=0) return dp[ind]
//        int left= f(ind -1, arr, dp)+ abs(arr[i]-arr[1]);
//    int right=Integer.MAX_VALUE
//        if ( index>1) right = f(ind -2, arr, dp)+ abs(arr[i]-arr[2]);
//    dp[ind]=Math.min(left,right)
//    return Math.min(left,right);
//      }

//    main{
//    int[] dp= int[n+1]
//    arr.fill(-1)
//    f(n-1, arr)

//    Tabulation:
//    Memoization was top down approach
//    Tabulation is bottom up
//      {
//    dp[0]=0  write base case
//    for (i=1 till n-1)
//    firstStep= dp(ind -1, arr, dp)+ abs(arr[ind]-arr[ind-1]);
//    if (i>1)
//    secondStep= dp(ind -2, arr, dp)+ abs(arr[ind]-arr[ind-2]);
//    dp[ind]= min(firstStep, secondStep)
//    }

//    Space Optimization
//    we dont actually require a full array , we just need a couple of variable
//{
//    int prev=0;
//            int prev2=0;
//            for(i=0, i<ind; i++){
//                int fs= prev+ abs(arr[ind]-arr[ind-1]);
//                int ss=Integer.MAX_VALUE;
//                if(i>1) ss= = prev2+ abs(arr[ind]-arr[ind-2]);
//
//                int curr= min(fs, ss);
//                prev2=prev;
//                prev=curr;
//            }
//            return prev;
//}

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 10};
//        System.out.println(getMinimumJumpEnergy(arr, 4));
        System.out.println(getMinimumJumpEnergyDP(arr, 4));
    }


    //recursive soln
    private static int getMinimumJumpEnergy(int[] arr, int n) {
        int ind = n - 1;
        if (ind == 0) {
            return 0;
        }
        int left = getMinimumJumpEnergy(arr, n - 1) + Math.abs(arr[ind] - arr[ind - 1]);
        int right = Integer.MAX_VALUE;
        if (ind > 1) right = getMinimumJumpEnergy(arr, n - 2) + Math.abs(arr[ind] - arr[ind - 2]);

        return Math.min(left, right);
    }

    private static int getMinimumJumpEnergyDP(int[] arr, int i) {
        int[] dp = new int[i + 1];
        Arrays.fill(dp, -1);
//        return getMinimumJumpEnergyDPMemo(arr, i, dp);
        return getMinimumJumpEnergyDPTabu(arr, i, dp);
    }

    //dp memoization
    private static int getMinimumJumpEnergyDPMemo(int[] arr, int n, int[] dp) {
        int ind = n - 1;
        if (ind == 0) {
            return 0;
        }
        if (dp[n] != -1) return dp[n];
        int left = getMinimumJumpEnergyDPMemo(arr, n - 1, dp) + Math.abs(arr[ind] - arr[ind - 1]);
        int right = Integer.MAX_VALUE;
        if (ind > 1) right = getMinimumJumpEnergyDPMemo(arr, n - 2, dp) + Math.abs(arr[ind] - arr[ind - 2]);
        dp[n] = Math.min(left, right);
        return Math.min(left, right);
    }

    //    dpTabulation
    private static int getMinimumJumpEnergyDPTabu(int[] arr, int n, int[] dp) {
        int ind=n-1;
        if(ind==0){
            dp[0]=0;
            return dp[0];
        }
        if(dp[n]!=-1) return dp[n];
        int firstStep=getMinimumJumpEnergyDPTabu(arr, n-1, dp)+Math.abs(arr[ind]-arr[ind-1]);
        int secondStep=Integer.MAX_VALUE;
        if(ind>1) secondStep=getMinimumJumpEnergyDPTabu(arr, n-2, dp)+Math.abs(arr[ind]-arr[ind-2]);
        dp[n]= Math.min(firstStep, secondStep);
        return dp[n];
    }

    private static int getMinimumJumpEnergyDPSpaceOptimization(int[] arr, int n) {
        int prev1=0;
        int prev2=0;
        for(int ind =1;ind<n;ind++){
            int firstStep=prev1+Math.abs(arr[ind]-arr[ind-1]);
            int secondStep=Integer.MAX_VALUE;
            if(ind>1) secondStep=prev2+Math.abs(arr[ind]-arr[ind-2]);
            int curi=Math.min(firstStep, secondStep);
            prev2=prev1;
            prev1=curi;

        }
        return prev1;
    }
}
