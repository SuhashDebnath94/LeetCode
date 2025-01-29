package blind75.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
//    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//
//    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//    You must write an algorithm that runs in O(n) time and without using the division operation.

//    Input: nums = [1,2,3,4]
//    Output: [24,12,8,6]

    //    Brute force solution: O(n^2)

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Arrays.stream(productExceptSelfPrac(nums)).forEach(x -> System.out.println(x));
    }


    //Division approach
    public static int[] productExceptSelf(int[] nums) {
        int[] op = new int[nums.length];
        boolean zero = false;
        int res = 1;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // it means second zero occurred hence return empty array
                if (zero) {
                    return op;
                }
                //else set index of zero element
                zero = true;
                index = i;
            } else {
                //prepare product
                res = res * nums[i];
            }

        }
        //check single zero case
        if (zero) {
            op[index] = res;
        } else {
            // it means no zero present
            for (int i = 0; i < nums.length; i++) {
                op[i] = res / nums[i];
            }
        }
        return op;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int[] sol = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sol[i] = 1;
        }
        int pre = 1;
        int post = 1;

        for (int i = 0; i < nums.length; i++) {
            sol[i] = sol[i] * pre;
            pre = pre * nums[i];
            sol[nums.length - i - 1] = sol[nums.length - i - 1] * post;
            post = post * nums[nums.length - i - 1];
        }
        return sol;
    }

    public static int[] productExceptSelfPrac(int[] nums) {
        int[] sol=new int[nums.length];

        Arrays.fill(sol, 1);
        int pre=1;
        int post=1;

        for (int i=0;i<nums.length;i++){
            sol[i]=sol[i]*pre;
            pre=pre*nums[i];
            sol[nums.length-i-1]=post*sol[nums.length-i-1];
            post=post*nums[nums.length-i-1];
        }
        return sol;
    }


}
