package arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N20_LongestConsequtiveSubsequence {
    /**
     * Find the longest consecutive subsequence in an array
     * {4,100, 101, 3, 102, 2, 1, 1}
     * <p>
     * longest subsequence is 4
     * 1,2, 3, 4
     */
//    public static void main(String[] args) {
//        Integer[] arr = {4, 100, 101, 3, 102, 2, 1, 1};
//        System.out.println(findLongestSubsequence(arr));
//    }
//
//    private static int findLongestSubsequence(Integer[] arr) {
//        if(arr.length==0) return 0;
//        int longest=1;
//        Set<Integer> set=new HashSet<>();
//        for (Integer i: arr){
//            set.add(i);
//        }
//        for(Integer i: set){
//            if(set.contains(i-1)){
//
//            }
//        }
//    }
    public static int findLongestConsecutiveSubsequence(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int longestStreak = 0;

        // Add all numbers to a set for O(1) lookup
        for (int num : nums) {
            set.add(num);
        }

        // Iterate through each number
        for (int num : set) {
            // Check if it's the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the consecutive sequence
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {4, 100, 101, 3, 102, 2, 1, 1};
        int result = findLongestConsecutiveSubsequence(nums);

        System.out.println("Longest consecutive subsequence length: " + result);
    }

}
