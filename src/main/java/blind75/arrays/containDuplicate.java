package blind75.arrays;

import java.util.HashSet;
import java.util.Set;

public class containDuplicate {
//    Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
//
//    Input: nums = [1,2,3,1]
//    Output: true

//    Time complexity brute force O(n^2)

//    We could use sorting where we sort the blind75.arrays and check if the neighbours are equal

//    We use the hashset method where we add in hashmap and check if item is not present in hashmap

    //    Time complexity optimal O(n)

    public boolean solutionOptimal(int[] nums) {
        // Create a hashset...
        HashSet<Integer> hset = new HashSet<Integer>();
        // Traverse all the elements through the loop...
        for (int idx = 0; idx < nums.length; idx ++){
            // Searches hashset. if present, it contains duplicate...
            if (hset.contains(nums[idx])){
                return true;
            }
            // if not present it will update hashset...
            hset.add(nums[idx]);
        }
        // Otherwise return false...
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 6};
        System.out.println(containsDuplicatePRac(arr));
    }

    private static boolean containsDuplicatePRac(int[] arr) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i< arr.length;i++){
            if(set.contains(arr[i])){
                return true;
            }
            set.add(arr[i]);
        }

        return false;
    }


}

