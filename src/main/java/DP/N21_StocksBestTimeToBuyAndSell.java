package DP;

import java.util.Arrays;

public class N21_StocksBestTimeToBuyAndSell {
    /**
     * It is like buy and see stock but you can buy any number of times and sell any number of times,
     * you need to sell one stock before buying another stock
     *
     */


    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        int dp[][]=new int[prices.length+1][2];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        System.out.println(maxProfit(prices, 0, false));
        System.out.println(maxProfitMemo(prices, 0, 0, dp));
    }

    private static int maxProfit(int[] prices, int ind, boolean boughtStock) {

        if(ind==prices.length) return 0;
        int profit=0;

        if(!boughtStock){
            profit=Math.max((-prices[ind] + maxProfit(prices, ind+1, true)) /*sell stock*/, (0+maxProfit(prices, ind+1, false) )) /*not sell stock*/;
        }
        else {
            profit=Math.max((prices[ind] + maxProfit(prices, ind+1, false)) , (0+maxProfit(prices, ind+1, true) ));
        }

        return profit;
    }

    private static int maxProfitMemo(int[] prices, int ind, int boughtStock, int[][] dp) {

        if(ind==prices.length) return 0;
        int profit=0;

        if(dp[ind][boughtStock]!=-1)
            return dp[ind][boughtStock];

        if(boughtStock==0){ //no stocks have been bought
            profit=Math.max((-prices[ind] + maxProfitMemo(prices, ind+1, 1, dp)) /*sell stock*/, (0+maxProfitMemo(prices, ind+1, 0, dp) )) /*not sell stock*/;
        }
        else {
            profit=Math.max((prices[ind] + maxProfitMemo(prices, ind+1, 0, dp)) , (0+maxProfitMemo(prices, ind+1, 1, dp) ));
        }

        return dp[ind][boughtStock]=profit;
    }

    /**
     * tabulation
     * 1) base case
     * 2) all the changing parameters (ind and bought)
     * 3) copy the recurrence
     */
    static long getMaximumProfitTabu(int[] Arr, int n)
    {
        long dp[][]=new long[n+1][2];
        for(long row[]: dp)
            Arrays.fill(row,-1);

        //base condition
        dp[n][0] = dp[n][1] = 0;

        long profit=0;

        for(int ind= n-1; ind>=0; ind--){
            for(int buy=0; buy<=1; buy++){
                if(buy==0){// We can buy the stock
                    profit = Math.max(0+dp[ind+1][0], -Arr[ind] + dp[ind+1][1]);
                }

                if(buy==1){// We can sell the stock
                    profit = Math.max(0+dp[ind+1][1], Arr[ind] + dp[ind+1][0]);
                }

                dp[ind][buy]  = profit;
            }
        }
        return dp[0][0];
    }

}
