package DP;

import java.util.Arrays;

public class GridUniquePaths {
    /**
     * DP on Grids:
     * -> Count paths
     * -> count paths with obstacles
     * -> Minimum path sum
     * -> maximum path sum
     * -> triangle
     * -> 2 start points
     * <p>
     * Generic steps for count ways :
             * 1) write base case which eturns either 0 or 1
             * 2) l = f()
             * 3) r = f()
             * 4) return l+r
     *
     * Problem 1: You are given a 2D matrix and you need to find all teh possible ways to go from the bottom left corner to the top right corner
     * Basically from 0,0 to (m-1, n-1)
     *
     * 1) express everything in terms of [i][j] since this is 2D.
     * 2) do all things at that index
     * 3) return Max/sum or whatever.

     * so firstly you break the matrix in smaller parts
     *
     * Base case: If you havE reached destination retun 0, else return 1.
     * if (i==0 && j==0)
         * {
         * return 1; since we have reached our destination. we count the path, and hence return 1
         * }
     *
     * if(i<0 || j< 0) { //we have exhausted the path during moving up or left, so we dont want to take that path
     *      return 0; //we havnt reached our destination
     * }
     *
     * up= f(i-1, j) moving up i is increasing, j is remaining same (row reduces and column remains the same)
     * left = f(i, j-1) moving j right while i stays constant (column reduces and row remains the same)
     * return up+left;
     * <p>
     * <p>
     * convert this into DP
     * there are over lapping sub problems here
     * we will require a 2D DP of mxn
     * initialize everything with -1
     * dp[i][j] = up+left;
     * check if answer has been previously stored if yes return from there.
     * TC: O(mxn)
     * SC: O[(n-1)+(m-1)]+O(nxm)
     * <p>
     * <p>
     * Tabulation:
     * 1) Write the base case
     * 2) express all states in for loop
     * 3) copy the recurrence and write
     * <p>
     * base case:
     * if dp[0][0] return 1
     * <p>
     * express in for loop
     * for(i=0 -> m-1)
     * for( j=0 -> n-1)
     * if(i==0 && j==0) dp[0][0]=1;
     * else{
     * if(i>0) up = dp[i-1][j];
     * if(j>0) left = dp[i][j-1]
     * dp[i][j]=up+left;
     * <p>
     * }
     * <p>
     * T: O(mxn)
     * S: O(mxn)
     */

    public static void main(String[] args) {
        int[][] matrix={
                {1, 3, 4},
                {1, 3, 4},
                {1, 3, 4}
        };
        long start = System.nanoTime();
        System.out.println(getAllPossiblePathsFromStartToFin(matrix));
        long end = System.nanoTime();
        System.out.println("Program takes " + (end - start) + " nano-seconds");
    }

    //Reccurence
    private static int getAllPossiblePathsFromStartToFin(int[][] matrix) {

        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<dp[0].length;i++){
            Arrays.fill(dp[i], -1);
        }
//        return getAllPossiblePathsFromStartToFinRec(matrix, n-1, m-1);
        return getAllPossiblePathsFromStartToFinDPMemo(matrix, n-1, m-1, dp);
    }

    private static int getAllPossiblePathsFromStartToFinRec(int[][] matrix, int i, int j) {
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        int up=getAllPossiblePathsFromStartToFinRec(matrix, i-1, j);
        int left=getAllPossiblePathsFromStartToFinRec(matrix, i, j-1);
        return up+left;
    }

    private static int getAllPossiblePathsFromStartToFinDPMemo(int[][] matrix, int i, int j, int[][] dp) {
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int up=getAllPossiblePathsFromStartToFinDPMemo(matrix, i-1, j, dp);
        int left=getAllPossiblePathsFromStartToFinDPMemo(matrix, i, j-1, dp);

        dp[i][j]=up+left;

        return up+left;
    }
}
