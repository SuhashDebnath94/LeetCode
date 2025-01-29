package strings;

public class N20_LongestRepeatingCharacterReplacement {
//    You are given a string s and an integer k.
//    You can choose any character of the string and change it to any other uppercase English character.
//    You can perform this operation at most k times.
//    Return the length of the longest substring containing the same letter you can get after performing the above operations.

//    Input: s = "ABAB", k = 2
//    Output: 4
//    Explanation: Replace the two 'A's with two 'B's or vice versa.

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA",1));
    }

    public static int characterReplacement(String s, int k) {
        // Make an array of size 26...
        int[] arr = new int[26];
        // Initialize largestCount, maxlen & beg pointer...
        int largestCount = 0, beg = 0, maxlen = 0;
        // Traverse all characters through the loop...
        for(int end = 0; end < s.length(); end ++){
            arr[s.charAt(end) - 'A']++;
            // Get the largest count of a single, unique character in the current window...
            largestCount = Math.max(largestCount, arr[s.charAt(end) - 'A']);
            // We are allowed to have at most k replacements in the window...
            // So, if max character frequency + distance between beg and end is greater than k...*
            // this means we have considered changing more than k charactres. So time to shrink window...*
            // Then there are more characters in the window than we can replace, and we need to shrink the window...
            if(end - beg + 1 - largestCount > k){     // The main equation is: end - beg + 1 - largestCount...
                arr[s.charAt(beg) - 'A']--;
                beg ++;
            }
            // Get the maximum length of repeating character...
            maxlen = Math.max(maxlen, end - beg + 1);     // end - beg + 1 = size of the current window...
        }
        return maxlen;      // Return the maximum length of repeating character...
    }
}
