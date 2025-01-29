package blind75.DP;

import java.util.Arrays;

public class HouseRobber {

//    You are a professional robber planning to rob houses along a street.
//    Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//    Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

//    Input: nums = [1,2,3,1]
//    Output: 4


//    Memoization steps:
//    1) create an array with all indexes as -1
//    2) Send it in util method along with array and length
//    3) if index is 0 then return 0
//    4) if index is 1 return the element at arr[0]
//    5) check if the index of dp array is not -1 if not then return that
//    6) set take as

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(houseRobber(arr));
    }

    private int tabulationSpaceOptimize(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        int max_val = 0;
        for (int ele : nums) {
            max_val = Math.max(ele + rob1, rob2);
            rob1 = rob2;
            rob2 = max_val;
        }
        return max_val;
    }

    //TC : O(n) ||  SC : (n)
    private static int memoizationUtil(int[] nums, int index, int[] dp) {
        if (index == 0) {
            return 0;
        }
        if (index == 1) {
            return nums[0];
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        int currentIndex = index - 1;
        int adjacentIndex = index - 2;

        int leave = memoizationUtil(nums, currentIndex, dp);// do not take current element
        int take = nums[currentIndex] + memoizationUtil(nums, adjacentIndex, dp); // take current element and ignore next
        // element
        dp[index] = Math.max(leave, take);
        return dp[index];
    }

    private static int memoization(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return memoizationUtil(nums, nums.length, dp);
    }

    //TC : O(n) ||  SC : (n)
    private int tabulation(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length == 1) {
            return dp[0];
        }
        dp[1] = Math.max(nums[1], dp[0]);
        for (int i = 2; i < nums.length; i++) {
            int leave = dp[i - 1];// do not take current element
            int take = dp[i - 2] + nums[i];// take current element and ignore next element
            dp[i] = Math.max(leave, take);
        }
        return dp[nums.length - 1];
    }

    public static int houseRobber(int[] nums) {
        // return tabulationSpaceOptimize(nums);
        return memoization(nums);
//        return tabulation(nums);
    }
}
