package DP;

import java.util.Arrays;

public class GridWithMazeObstacles {
    /**
     * There is a 2x 2 matrix, go from 0,0 to n, m , find all the ways
     *
     * There are some obstacles in between which are marked as -1
     *
     * How many ways  can you go by
     *
     * if(i> =0 && j>=0 && a[i][j]= -1 return 0; this means when you have a obstacle you have a base case.
     *
     *
     * Memoization:
     *if (i==0 && j==0)
     *  *      {
     *  *          return 1; since we have reached our destination. we count the path, and hence return 1
     *  *      }
     *  *      if(i<0 || j< 0) { //we have exhausted the path during moving up or left, so we dont want to take that path
     *  *          return 0; //we havnt reached our destination
     *  *      }
     *  if (dp[i][j] != -1) return dp;
     *
     *  *
     *  *      up= f(i-1, j) moving up i is increasing, j is remaining same (row reduces and column remains the same)
     *  *      left = f(i, j-1) moving j right while i stays constant (column reduces and row remains the same)
     *  *      return up+left;
     *
     *
     *  tabulation:
     *      for(i=0 -> m-n)
     *          for(j=0 -> n-1)
     *              if(dp[i][j] == -1) return 0;
     *              else if if(i==0) && (j==0) dp[i][j]=1;
     *              else
     *              if(i>0)    up = dp[i-1][j]
     *              if(j>0)    left=dp[i][j-1];
     *
     *                 return up+left;
     *
     */


    public static void main(String[] args) {
        int[][] matrix={
                {1, 3, 4},
                {1, -1, 4},
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
        return getAllPossiblePathsFromStartToFinRec(matrix, n-1, m-1);
//        return getAllPossiblePathsFromStartToFinDPMemo(matrix, n-1, m-1, dp);
    }

    private static int getAllPossiblePathsFromStartToFinRec(int[][] matrix, int i, int j) {
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(matrix[i][j]==-1){
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
        if(matrix[i][j]==-1){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int up=getAllPossiblePathsFromStartToFinDPMemo(matrix, i-1, j, dp);
        int left=getAllPossiblePathsFromStartToFinDPMemo(matrix, i, j-1, dp);

        dp[i][j]=up+left;

        return up+left;
    }
}
