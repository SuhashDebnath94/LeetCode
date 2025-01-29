package strings;

public class N05_ValidPalindrome {
//    “Given a string, check if the string is palindrome or not.”
//    A string is said to be palindrome if the reverse of the string is the same as the string.
//    Example 1:
//Input: Str =  “ABCDCBA”
//Output: Palindrome
//Explanation: String when reversed is the same as string.
//
//Example 2:
//Input: Str = “TAKE U FORWARD”
//Output: Not Palindrome
//Explanation: String when reversed is not the same as string.

    static private boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left<right)
        {
            char l = s.charAt(left), r = s.charAt(right);
            if(!Character.isLetterOrDigit(l))
                left++;
            else if(!Character.isLetterOrDigit(r))
                right--;
            else if(Character.toLowerCase(l)!=Character.toLowerCase(r))
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "ABCDCBA";
        boolean ans = isPalindromePrac(str);

        if (ans == true) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }

    private static boolean isPalindromePrac(String str) {
        int left=0;
        int right=str.length()-1;

        if(str.length()==1){
            return true;
        }

        while(left<right){
            if(Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
