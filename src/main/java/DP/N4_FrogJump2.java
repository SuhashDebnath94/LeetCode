package DP;

import java.util.Arrays;

public class N4_FrogJump2 {
//    Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair.
//    At a time the frog can climb either K steps. A height[N] array is also given.
//    Whenever the frog jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference.
//    We need to return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1.

    public static void main(String[] args) {

        int[] arr = {10, 30, 40, 50, 20};
        int[] dp=new int[5];
        Arrays.fill(dp, -1);
        System.out.println(getMinimumJumpEnergyDPKJumps(arr, 4, 3, dp));
    }

    private static int getMinimumJumpEnergyDPKJumps(int[] arr, int size, int k, int[] dp) {
        int ind=size-1;
        if(ind==0){
            dp[0]=0;
            return dp[0];
        }
        if(dp[size]!=-1) return dp[size];
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(size-i>0){
                int step=getMinimumJumpEnergyDPKJumps(arr,size-i,k,dp)+Math.abs(arr[ind]-arr[ind-i]);
                min=Math.min(min, step);
            }
        }
        dp[size]=min;
        return min;
    }
}
