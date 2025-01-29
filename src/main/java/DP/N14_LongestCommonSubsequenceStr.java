package DP;

import java.util.Arrays;

public class N14_LongestCommonSubsequenceStr {

//    it is a subsequence as long as it maintains the order.

    /**
     * Find the longest common subsequence between 2 strings
     *
     * adebc  dcadb  -> adb
     * length -> 3
     *
     *
     * Brute force:
     *  Generate all subsequences of both strings and compare linearly
     *  T= O(2^n)
     *
     *
     *  so first we will need 2 indexes here since there are 2 strings
     *  f(2,5) represesents that the function will give lcs between s1 0-2 and s2 0-5
     *
     *  so suppose strings are acd and ced
     *
     *  we compare the 2 ds
     *  since they match we have a lcs of length 1
     *
     *  now we need to shrink the strings and check whether anything else matches
     *  ac | ce now pointers are at c and e that is f(1,1)
     *
     *  so if
     *      s1[ind1]==s2[ind2]
     *          1+f(ind1-1,ind2-1)
     *
     * if it matches you add 1 and move back 1
     * if not the add 0 and move back each one and compare which one matches and then take the max and add
     *
     */


    //TC -> O(m x n)
    //SC -> O(m+n) in auxillary stack space.

    static int lcsUtil(String s1, String s2, int ind1, int ind2, int[][] dp){

        if(ind1<0 || ind2<0)
            return 0;

        if(dp[ind1][ind2]!=-1)
            return dp[ind1][ind2];

        //match
        if(s1.charAt(ind1) == s2.charAt(ind2))
            return dp[ind1][ind2] = 1 + lcsUtil(s1,s2,ind1-1,ind2-1,dp);

        else
            //doesnt match
            return dp[ind1][ind2] = 0 + Math.max(
                    lcsUtil(s1,s2,ind1,ind2-1,dp),
                    lcsUtil(s1,s2,ind1-1,ind2,dp)
            );

    }


    static int lcs(String s1, String s2) {

        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n][m];
        for(int rows[]: dp)
            Arrays.fill(rows,-1);
        return lcsUtil(s1,s2,n-1,m-1,dp);
    }

    public static void main(String args[]) {

        String s1= "acd";
        String s2= "ced";

        System.out.println("The Length of Longest Common Subsequence is "+lcs(s1,s2));
    }

    /**
     * For Tabulation
     * 1) Copy the base case
     * 2) write the changeing params in opposite fashion
     * 3) copy the recurrence
     */
    static int lcsTabu(String s1, String s2) {

        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n+1][m+1];
        for(int rows[]: dp)
            Arrays.fill(rows,-1);

        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }

        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }

        return dp[n][m];
    }
}
