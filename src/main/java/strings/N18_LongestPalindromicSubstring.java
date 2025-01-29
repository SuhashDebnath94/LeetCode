package strings;

public class N18_LongestPalindromicSubstring {

 //    Given a string s, return the longest palindromic substring in s.
//    Input: s = "babad"
//    Output: "bab"
//    Explanation: "aba" is also a valid answer.
    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstringPrac("babad"));
    }

    public static String longestPalindrome(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];

        String ans = "";
        int maxLength = 0;
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < s.length(); i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                        ;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }

                if (dp[i][j]) {
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }

    /*
    Logic:
           We will go character by character and expand from it to find the longest palindromic that can be formed from it
           if length is greater than our current result we update the result

     */

    /**
     * Manachers algorithm
     */
    public static String longestPalindromicSubstringPrac(String s){
        if(s.length()==0) return "";
        if(s.length()==1) return s;

        int start=0;
        int end=0;
        for(int i=0; i<s.length(); i++){
            int length1= expandFromMiddle(s, i, i); //checking for odd number of character palindromes, like aba, so frist it will check against b at both pointers
            int length2= expandFromMiddle(s, i, i+1);  //checking for even number of character palindromes, like abba
            int length= Math.max(length2, length1);
            if (length> end-start) {
                start= i- (length-1)/2;
                end= i+ length/2;

            }
        }
        return s.substring(start, end+1);
    }

//    This is our method to take a string, expand from the moddle and find a palindrome
    private static int expandFromMiddle(String s, int left, int right) {
        if(s==null || left>right){
            return 0;
        }
        while (left>0 && right <s.length() && s.charAt(left) == s.charAt((right))){
            left--;
            right++;
        }
        return right-left-1;
    }

    //Manachers algorithm
//    We will have 3 pointers initially all pointing to i=0
//    palindromic string is of 3 parts left right and center
//    if it is of odd length it can have a center or else it will have 2 equal halves

//    Lets take odd length first
//    initially all left right and center pointers will be at 0
//    we create an array which will contain how many values match each other on each side of the index for a given index
//    so if center is at 4(index) the vaule of 4 is 3 then there will be 3 values on each side on right and left side of 4th index.
//    if there is no before and after values matching then the value of that index should be 0

//    Now if we have calculated the values till a point then it can be safe to say the vaues after the center are mirror images of the values before the center

}
