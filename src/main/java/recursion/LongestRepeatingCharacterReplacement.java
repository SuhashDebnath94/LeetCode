package recursion;

public class LongestRepeatingCharacterReplacement {

//    You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
//
//    Return the length of the longest substring containing the same letter you can get after performing the above operations.

//    Input: s = "ABAB", k = 2
//    Output: 4
//    Explanation: Replace the two 'A's with two 'B's or vice versa.

    public static void main(String[] args) {
        System.out.println(longestRepeatingCharacterReplacement("AABABBA", 1));
    }

    private static int longestRepeatingCharacterReplacement(String input, int k) {

//        we move our window from A
//        there is B which is not equal to A but can be replaced by A so we can still move but operations now is 1;
//        we move again because operations is still A
//        we move again since we can replace B by A


        int n = input.length();
        int[] char_counts = new int[26]; //each index contains the number of times a character repeats

        int window_start = 0;
        int max_length = 0; //this is going to be our result
        int max_count = 0; //keeps track of the number of repeating characters we are looking for


        for (int window_end = 0; window_end < n; window_end++) {
            int char_index = input.charAt(window_end) - 'A';  //the index of the character at window end
            char_counts[char_index]++;                      //we increment that index by 1
            int current_char_count = char_counts[char_index]; //count of the current character we are looking at
            max_count = Math.max(max_count, current_char_count); //max of the current max count and the count of character we saw and incremented

            int sizeOfWindow = window_end - window_start;
            int sizeOfWindowMinusSameCharacters = sizeOfWindow - max_count;  //this is the number of different characters
            while (window_end - window_start - max_count + 1 > k) { //we add 1 because we are adding a new letter on each loop
                char_counts[input.charAt(window_start) - 'A']--; //decrement the front character.
                window_start++;
            }

            max_length = Math.max(max_length, window_end - window_start + 1);
        }

        return max_length;
    }
}
