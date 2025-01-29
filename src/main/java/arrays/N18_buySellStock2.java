package arrays;

public class N18_buySellStock2 {
//    You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
//
//    On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
//
//    Find and return the maximum profit you can achieve.

//    Input: prices = [7,1,5,3,6,4]
//    Output: 7
//    Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//    Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//    Total profit is 4 + 3 = 7.


    public static void main(String[] args) {
        int[] input = {7,1,3,8,6,11};
        System.out.println(getMaximumProfit(input, 0, input.length - 1));
        System.out.println(getMaximumProfit2(input));
    }

    private static int getMaximumProfit2(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        boolean bought = false;
        boolean sold = true;
        int buy = 0;
        int sell = 0;
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int j = i + 1;
            if (prices[i] < prices[j] && sold == true) {
                buy = prices[i];
                bought = true;
                sold = false;
            }
            if (prices[i] > prices[j] && bought == true) {
                sell = prices[i];
                bought = false;
                sold = true;
                profit = profit + (sell - buy);
            }

        }
        if (sold == false) {
            sell = prices[prices.length - 1];
            profit = profit + (sell - buy);
        }
        return profit;
    }

    private static int getMaximumProfit(int[] input, int start, int end) {
        if (end <= start)
            return 0;
        int profit = 0;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (input[i] < input[j]) {
                    int profitTemp = input[j] - input[i]
                            + getMaximumProfit(input, start, i - 1)
                            + getMaximumProfit(input, j + 1, end);

                    // Update the maximum profit so far
                    profit = Math.max(profit, profitTemp);
                }
            }
        }
        return profit;
    }
}
