package DP;

import java.util.Arrays;

public class N18_MinimumInsertionPalindrome {
    /**
     * We first find the longest palindromin subsequence
     * wee keep that intact
     * We just need to insert the other letters to make a palindrome
     * So the length of the string - the length of longest palindromic subsequence is minimum insertions required to make a palindrome
     */

    static int lcs(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        return dp[n][m];
    }

    static int longestPalindromeSubsequence(String s) {
        String t = s;
        String ss = new StringBuilder(s).reverse().toString();
        return lcs(ss, t);
    }

    public static void main(String args[]) {

        String s = "codingninjas";

        System.out.print("The Length of Longest Palindromic Subsequence is ");
        System.out.println(minimumInsertionPalindrom(s));
    }

    private static int minimumInsertionPalindrom(String s) {
        return s.length() - longestPalindromeSubsequence(s);
    }
}
