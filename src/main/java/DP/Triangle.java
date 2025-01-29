package DP;

import java.util.Arrays;

public class Triangle {
    /**
     * You are given a triangular array, Your task is to find the mimimum path sum to reach from top to bottom row.
     * The triangle array will have n rows, and the ith row where 0<=i < N will have i+1 elements
     * You can only move to the adjacent number of row below each step so if you are at index[i][j] you can move i to i+1 and/or j to j+1
     */

    public static void main(String[] args) {
        int[][] arr = {
                {1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}
        };

        System.out.println(getMinimumPath(arr));


    }

    private static int getMinimumPath(int[][] arr) {
        int[][] dp=new int[arr.length][arr[arr.length-1].length];

        for (int i=0;i<arr.length;i++){
            Arrays.fill(dp[i], -1);
        }
//        return getMinimumPathRec(arr, 0, 0);
        return getMinimumPathDP(arr, 0, 0, dp);

    }

    //    TC: O(nxn)
//    SC: O(n)
    private static int getMinimumPathDP(int[][] arr, int i, int j, int[][] dp) {
        if(i==arr.length-1){
            return arr[arr.length-1][j];
        }
        if(dp[i][j] != -1) return dp[i][j];
        int down=arr[i][j]+getMinimumPathDP(arr, i+1, j, dp);
        int downRight=arr[i][j]+getMinimumPathDP(arr, i+1, j+1, dp);

        dp[i][j]=Math.min(down, downRight);
        return Math.min(down, downRight);
    }

    //    TC: O(2^n)
//      SC: O(N)
    private static int getMinimumPathRec(int[][] arr, int i, int j) {
        if(i==arr.length-1){
            return arr[arr.length-1][j];
        }
        int down=arr[i][j]+getMinimumPathRec(arr, i+1, j);
        int downRight=arr[i][j]+getMinimumPathRec(arr, i+1, j+1);

        return Math.min(down, downRight);

    }
}
