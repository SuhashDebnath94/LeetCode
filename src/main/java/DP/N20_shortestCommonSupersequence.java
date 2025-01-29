package DP;

import java.util.Arrays;

public class N20_shortestCommonSupersequence {
    /**
     * Find the shortest string that contains both s1 and s2
     */

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
            return dp[ind1][ind2] = 0 + Math.max(lcsUtil(s1,s2,ind1,ind2-1,dp),
                    lcsUtil(s1,s2,ind1-1,ind2,dp));

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

        String s1= "bleed";
        String s2= "blue";

        System.out.println("The Length of Shortest common supersequence is "+scs(s1,s2));
    }

    private static int scs(String s1, String s2) {
        int lcs=lcs(s1, s2);
        return lcs+(s1.length()-lcs)+(s2.length()-lcs);
    }
}
