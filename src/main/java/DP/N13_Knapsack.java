package DP;

import java.util.Arrays;

public class N13_Knapsack {
    /**
     * A thief wants to rob a store.
     * He is carrying a bag of capacity W.
     * The store has ‘n’ items.
     * Its weight is given by the ‘wt’ array and its value by the ‘val’ array.
     * He can either include an item in its knapsack or exclude it but can’t partially have it as a fraction.
     * We need to find the maximum value of items that the thief can steal.
     * <p>
     * 1) We need to express everything in terms of index and weights
     * 2) Explore all possibilities using pick and non pick
     * 3) Get maximum of those.
     * <p>
     * <p>
     * if last element can fit in bag:
     * if(wt[0]<=w) return val[0];
     * else return 0;
     * <p>
     * <p>
     * not_take= 0+f(n-1, w)
     * take=Integer.Min
     * if(wt[ind]<=w){
     * take=val[ind]+f(n-1, w-w[ind])
     * }
     * <p>
     * max(take, notTake)
     * <p>
     * In memoization
     * create n x w+1 array
     */

    static int knapsackUtil(int[] wt, int[] val, int ind, int W, int[][] dp) {
        if (ind == 0) {
            if (wt[0] <= W) return val[0];
            else return 0;
        }

        if (dp[ind][W] != -1) return dp[ind][W];

        int notTaken = 0 + knapsackUtil(wt, val, ind - 1, W, dp);

        int taken = Integer.MIN_VALUE;
        if (wt[ind] <= W) taken = val[ind] + knapsackUtil(wt, val, ind - 1, W - wt[ind], dp);

        return dp[ind][W] = Math.max(notTaken, taken);
    }


    static int knapsack(int[] wt, int[] val, int n, int W) {

        int dp[][] = new int[n][W + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return knapsackUtil(wt, val, n - 1, W, dp);
    }

    public static void main(String args[]) {

        int wt[] = {1, 2, 4, 5};
        int val[] = {5, 4, 8, 6};
        int W = 5;

        int n = wt.length;

        System.out.println("The Maximum value of items, thief can steal is " + knapsack(wt, val, n, W));
    }

    static int knapsackTabu(int[] wt,int[] val, int n, int W){

        int dp[][] = new int[n][W+1];

        //Base Condition

        for(int i=wt[0]; i<=W; i++){
            dp[0][i] = val[0];
        }

        for(int ind =1; ind<n; ind++){
            for(int cap=0; cap<=W; cap++){

                int notTaken = 0 + dp[ind-1][cap];

                int taken = Integer.MIN_VALUE;
                if(wt[ind] <= cap)
                    taken = val[ind] + dp[ind-1][cap - wt[ind]];

                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }

        return dp[n-1][W];
    }
}
