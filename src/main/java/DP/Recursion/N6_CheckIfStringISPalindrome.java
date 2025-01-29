package DP.Recursion;

public class N6_CheckIfStringISPalindrome {
    public static void main(String[] args) {
        System.out.println( checkIfStringISPalindrome("MADAM", 0));
    }

    private static boolean checkIfStringISPalindrome(String input, int i) {
        if(i>input.length()/2) return true;
        if(input.charAt(i)!=input.charAt(input.length()-i-1)){
            return false;
        }
        return checkIfStringISPalindrome(input, i+1);
    }
}
