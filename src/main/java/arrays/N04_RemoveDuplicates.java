package arrays;

import java.util.Objects;

public class N04_RemoveDuplicates {

//    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
//    The relative order of the elements should be kept the same.

    public static void main(String[] args) {
        Integer[] input = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        ArrayUtil.printAllElements(removeDuplicates(input));
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

