package blind75.DP;

import java.util.HashSet;

public class WordDict {
    /**
     * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
     *
     * Input: s = "leetcode", wordDict = ["leet","code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     *
     * Input: s = "applepenapple", wordDict = ["apple","pen"]
     * Output: true
     * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
     * Note that you are allowed to reuse a dictionary word.
     *
     * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
     * Output: false
     *
     * Approach 1) Backtracking
     *  -> We partition at each possible partition point that is after each character. But that will be waste of time
     *  -> We partition at points which make words which are already present in the dictionary
     *  -> In worst case all the letters of the string are present in the dictionary
     *  -> For a string of length n there can be at max n partition points
     *  -> For each position you can either have a partition or not have a partition.
     *
     *  Optimal substructure suggests that if you have a solution for a smaller sub problem it will help you to build a soln for bigger problem
     *
     *  It is valid in this case since suppose for leetcode if you know leet is present in dictionary you just need to find if partitions of code is present in dictionary
     *  
     */

    public static void main(String[] args) {
        HashSet<String> wordDict=new HashSet<>();
        wordDict.add("leet");
        wordDict.add("code");
        
        String str="leetcode";

        System.out.println(wordBreak(str, wordDict));
    }

    private static boolean wordBreak(String word, HashSet<String> dictionary) {

        int size = word.length();

        // base case
        if (size == 0)
            return true;

        //else check for all words
        for (int i = 1; i <= size; i++)
        {
            // Now we will first divide the word into two parts ,
            // the prefix will have a length of i and check if it is
            // present in dictionary ,if yes then we will check for
            // suffix of length size-i recursively. if both prefix and
            // suffix are present the word is found in dictionary.

            if (dictionary.contains(word.substring(0,i)) &&
                    wordBreak(word.substring(i,size), dictionary))
                return true;
        }

        // if all cases failed then return false
        return false;

    }
}
