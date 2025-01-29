package DP;

import java.util.Arrays;

public class N1_Fibonacci {
    public static void main(String[] args) {
        System.out.println(findFibo(5));
    }

    private static int findFibo(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

//        return findFiboMemo(n, dp);
        return findFiboSpaceOptimization(n);
    }

    private static int findFiboTabu(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    private static int findFiboSpaceOptimization(int n) {
        int prev2 = 0;
        int prev = 1;
        for (int i = 2; i <= n; i++) {
            int curi = prev + prev2;
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }

    private static int findFiboMemo(int n, int[] dp) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (dp[n] != -1) return dp[n];

        dp[n] = findFiboMemo(n - 1, dp) + findFiboMemo(n - 2, dp);

        return dp[n];

    }
}
