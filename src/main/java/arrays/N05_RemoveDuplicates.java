package arrays;

import java.util.Objects;

public class N05_RemoveDuplicates {

    /*
    Given an integer array nums sorted in non-decreasing order,
    remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

    Consider the number of unique elements of nums to be k,
    to get accepted, you need to do the following things:
        Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
    Return k.
     */
    public static void main(String[] args) {
        Integer[] input = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        ArrayUtil.printAllElements(removeDuplicates(input));
        System.out.println();
        System.out.println("First "+removeDuplicates2(input)+" Elements are sorted in the array :");
        ArrayUtil.printAllElements(input);
    }

    private static Integer removeDuplicates2(Integer[] nums) {
            if (nums.length == 0) return 0;

            int i = 0; // Pointer for unique elements
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) { // Found a unique element
                    i++;
                    nums[i] = nums[j]; // Move it to the correct position
                }
            }
            return i + 1; // Return count of unique elements
    }

    private static Integer[] removeDuplicates(Integer[] nums) {

        Integer[] res = new Integer[nums.length];
        res[0] = nums[0];
        int pointer = 1;
        for (int i = 1; i < nums.length; i++) {
            if (!Objects.equals(nums[i], nums[i - 1])) {
                res[pointer] = nums[i];
                pointer++;
            }
        }
        return res;
    }


}

