package DP;

import java.util.Arrays;

public class N6_HouseRobber2 {
    //    A thief needs to rob money in a street. The houses in the street are arranged in a circular manner.
//    Therefore the first and the last house are adjacent to each other.
//    The security system in the street is such that if adjacent houses are robbed, the police will get notified.


//    same logic as last one exceptdo it with leaving out first element and then again with leaving out last element. then the answer will be the max of both.
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        int[] dp = new int[5];
        Arrays.fill(dp, -1);
        System.out.println(houseRobberDP2(arr, arr.length, dp));
    }

    private static int houseRobberDP2(int[] arr, int length, int[] dp) {
        int[] arrExceptLast=new int[arr.length-1];
        int[] arrExceptFirst=new int[arr.length-1];

        for(int i=1;i<arr.length;i++){
            arrExceptFirst[i-1]=arr[i];
        }
        for(int i=0;i<arr.length-1;i++){
            arrExceptLast[i]=arr[i];
        }

        int leaveOutFirst=houseRobber2Soln(arrExceptFirst, arrExceptFirst.length, dp);
        int leaveLast=houseRobber2Soln(arrExceptLast, arrExceptLast.length, dp);
        return Math.max(leaveOutFirst, leaveLast);
    }

    private static int houseRobber2Soln(int[] arr, int length, int[] dp){
        int ind=length-1;
        if(ind==0){
            dp[0]=arr[ind];
            return arr[0];
        }
        if(ind<0){
            return 0;
        }
        if(dp[length]!=-1) return dp[length];
        int pick=arr[ind]+houseRobber2Soln(arr, length-2, dp);
        int leave=0+houseRobber2Soln(arr, length-1, dp);
        dp[length]=Math.max(pick,leave);
        return Math.max(pick,leave);
    }

}
