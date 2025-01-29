package DP;

public class MinimumSumPath {
    /**
     * in a nxm matrix, each cell has a weight attached to it, find the minimum possible path to go from 0,0 to n-1, m-1
     *
     *
     * Greedy will not work since the numbers are not uniform
     *
     * 1 8 10
     * 10 12 100
     * 1 1  7
     *
     * Here 1-> 8-> 10 -> 100 -> 7 is the greedy path  which is 126
     * but 1-> 10 -> 1 -> 1 -> 7 is the most efficient path 20
     *
     * So greedy will not work
     *
     * So we need to recursively find all the paths and then find the minimum
     *
     * Recurrence algo:
     *  f(i,j){
     *          if(i==0 && j==0) return a[0][0];
     *          if(i<0 || j<0) return Integer.MAx_Value
     *
     *          up=a[i][j]+f(i-1, j);
     *          left=a[i][j]+f(i, j-1);
     *
     *          return minimum(left, up)
     *
     *  }
     *
     *  Memoization:
     *      f(i,j)
     *      {
     *          if(i==0 && j==0) return a[0][0];
     *          if(i<0 || j<0) return Integer.MAx_Value
     *          if(dp[i][j] !=-1) return dp[i][j];
     *
     *          up=a[i][j]+f(i-1, j);
     *          left=a[i][j]+f(i, j-1);
     *
     *          return minimum(left, up)
     *      }
     *
     * Tabulation:
     *  f(i,j)
     *      for(i = 0-> n-1)
     *          for(j= 0-> m-1)
     *            if(i==0 && j==0) dp[i][j]=a[0][0]
     *            up= a[i][j]+dp[i-1][j]
     *            left= a[i][j]+dp[i][j-1]
     *            dp[i][j]=minimum[up, left]
     *
     *            return dp[i][j]
     *
     *
     * Space optimization:
     *      Instead of carrying the full DP just carry the current row and previous row
     *
     *
     */

    public static void main(String[] args) {
        int[][] matrix={
                {1, 3, 4},
                {1, 1, 4},
                {1, 1, 4}
        };
        long start = System.nanoTime();
        System.out.println(getMinimumPath(matrix));
        long end = System.nanoTime();
        System.out.println("Program takes " + (end - start) + " nano-seconds");
    }

    private static int getMinimumPath(int[][] matrix) {
        int n=matrix.length;
        int m= matrix[0].length;
        return getMinimumPathRecurring(matrix, n-1, m-1);
    }

    private static int getMinimumPathRecurring(int[][] matrix, int i, int j) {
        if(i==0 && j==0){
            return matrix[0][0];
        }
        if (i<0 || j<0){
            return Integer.MAX_VALUE;
        }
        int up=matrix[i][j]+getMinimumPathRecurring(matrix, i-1, j);
        int left=matrix[i][j]+getMinimumPathRecurring(matrix, i, j-1);

        return Math.min(up, left);
    }
}
