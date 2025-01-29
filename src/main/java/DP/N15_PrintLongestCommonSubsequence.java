package DP;

public class N15_PrintLongestCommonSubsequence {

    /**
     * Print Longest Common Subsequence
     * <p>
     * do the same as previous but backtrack and as you move back keep storing the matched elements in a ds
     *
     * strings
     *  abcde and bdgek
     *
     * At starting i=5 and j=5.
     * As S1[4] != S2[4], we move to the left side (←) as it’s value is greater than the top value(↑), therefore i=5 and j=4
     * As S1[4] == S2[3], we add the current character to the str string(at last) and move to i-1 and j-1 cell i.e top-left(↖), therefore i=4 and j=3.
     * As S1[3] != S2[2], we move to the left cell (←) as its value is larger than the top cell(↑), i becomes 4 and j becomes 2.
     * As S1[3] == S2[1], we will add this character to str string and we will move to the top-left cell (↖) i becomes 3 and j becomes 1
     * As S1[2] != S2[1], we will move to the top cell (↑) as its value is greater than the left cell (←). Now i become 2 and j remains 1.
     * As S1[1] == S2[0], we will add this character to str string and we will move to the top-left cell (↖) i becomes 1 and j becomes 1 and j becomes 0.
     * As j is zero, we have hit the exit condition so we will break out of the loop and str contains the longest common subsequence.
     */

    static void lcs(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else dp[ind1][ind2] = 0 + Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        int len = dp[n][m];
        int i = n;
        int j = m;

        int index = len - 1;
        String str = "";
        for (int k = 1; k <= len; k++) {
            str += "$"; // dummy string
        }
        StringBuilder ss = new StringBuilder(s1);
        StringBuilder str2 = new StringBuilder(str);
        while (i > 0 && j > 0) {
            if (ss.charAt(i - 1) == s2.charAt(j - 1)) {
                str2.setCharAt(index, ss.charAt(i - 1));
                index--;
                i--;
                j--;
            } else if (ss.charAt(i - 1) > s2.charAt(j - 1)) {
                i--;
            } else j--;
        }
        System.out.println(str2);
    }

    public static void main(String args[]) {

        String s1 = "abcde";
        String s2 = "bdgek";

        System.out.print("The Longest Common Subsequence is ");
        lcs(s1, s2);
    }
}
