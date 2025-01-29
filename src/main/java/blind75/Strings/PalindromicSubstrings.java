package blind75.Strings;

public class PalindromicSubstrings {

//    Given a string s, return the number of palindromic substrings in it.
//
//    A string is a palindrome when it reads the same backward as forward.
//
//    A substring is a contiguous sequence of characters within the string.

//    Step 1: Start a for loop to point at every single character from where we will trace the palindrome string.
//            checkPalindrome(s,i,i); //To check the palindrome of odd length palindromic sub-string
//    checkPalindrome(s,i,i+1); //To check the palindrome of even length palindromic sub-string
//
//    Step 2: From each character of the string,
//    we will keep checking if the sub-string is a palindrome and increment the palindrome count.
//    To check the palindrome, keep checking the left and right of the character if it is same or not.

    public static void main(String[] args) {
        System.out.println(countPalindromicSubstrings("abbc"));
    }

    private static int countPalindromicSubstrings(String aba) {
        return countPalindromicSubstrings(aba, 0, 0);
    }

    private static int countPalindromicSubstrings(String input, int ind, int count) {
        if (input == null || input.length() == 0) return 0;

        for(int i=0; i<input.length(); i++){
            count = checkPalindrome(input,i,i, count);     //To check the palindrome of odd length palindromic sub-string
            count= checkPalindrome(input,i,i+1, count);   //To check the palindrome of even length palindromic sub-string
        }
        return count;
    }

    private static int checkPalindrome(String s, int i, int j, int count) {
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){    //Check for the palindrome string
            count++;    //Increment the count if palindromin substring found
            i--;    //To trace string in left direction
            j++;    //To trace string in right direction
        }
        return count;
    }

}
