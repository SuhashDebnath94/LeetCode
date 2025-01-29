package arrays;

import java.util.*;

public class N25_TwoSum {

//    Given an array of i
//    return indices of the two numbers such that they add up to target.
//
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//    You can return the answer in any order.


//        Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    public static void main(String[] args) {

//        Method 1: Iterate through the array and check if target - A[i] exists in the remaining part of the array or not
//        Time complexity would be O(n^2)

//        Method 2:
//            Create a hash table
//        take first element of array and check if target - A[i] is present in hash table, if not then put(A[i], i);
//        Keep doing and you will reach a point where it is present as for example we first put(2,0), and then search 9-7 in
//        we find 2 and we create the result out of it.
//        Time complexity: O(n)
//        Space complexity: O(n)

//        Method 3:
//            Sort the array
//            have 2 pointers at start and end
//        while low<high
//        if low + high is higher than target decrease high else increase low


        Integer[] arr={7, 2, 11, 15};
        Arrays.stream(twoSumPrac(arr, 9)).forEach(x -> System.out.println(x));

    }

    private static Integer[] twoSumPrac(Integer[] arr, Integer target) {

        Set<Integer> counter=new HashSet<>();

        for(int i=0;i<arr.length;i++){
            if(counter.contains(target-arr[i])){
                Integer[] res={arr[i], target-arr[i]};
                return res;
            }
            counter.add(arr[i]);
        }

        return null;
    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                return new int[] {numToIndex.get(target - nums[i]), i};
            }
            numToIndex.put(nums[i], i);
        }
        return new int[] {};
    }
}
