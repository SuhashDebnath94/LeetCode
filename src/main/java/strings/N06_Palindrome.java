package strings;

public class N06_Palindrome {

//    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward.
//    Alphanumeric characters include letters and numbers.

    public static void main(String[] args) {
        System.out.println(isPalindrome("ab@a"));
    }

    private static boolean isPalindrome(String str) {
        str=str.toLowerCase();
        str= str.replaceAll("[^A-Za-z0-9]","");
        str=str.replaceAll("\\ ", "");

        int low=0;
        int high=str.length()-1;

        while(low<high){
            if(str.charAt(low)==str.charAt(high)){
                low++;
                high--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
