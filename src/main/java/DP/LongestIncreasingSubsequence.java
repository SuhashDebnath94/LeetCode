package DP;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

//    Given an integer array nums, return the length of the longest strictly increasing subsequence
//
//    Input: nums = [10,9,2,5,3,7,101,18]
//    Output: 4
//    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

    public static void main(String[] args) {
        int[] input={10,9,2,5,3,7,101,18};
        System.out.println(getLongestIncreasingSubsequence(input));
    }

    private static int getLongestIncreasingSubsequence(int[] input) {
        int[] dp=new int[input.length+1];
        Arrays.fill(dp,-1);
        return getLongestIncreasingSubsequence(input, dp, 0, -1);
    }

    private static int getLongestIncreasingSubsequence(int[] input, int[] dp, int index, int prev) {
        if(index==input.length){
            return 0;
        }
        int length=0+getLongestIncreasingSubsequence(input, dp, index+1, prev); //not take
        if(prev == -1 || input[index]> input[prev]){
            length=Math.max(length, 1+getLongestIncreasingSubsequence(input, dp, index+1,index)); //take
        }
        return length;
    }
}
