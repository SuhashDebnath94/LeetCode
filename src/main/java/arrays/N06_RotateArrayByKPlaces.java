package arrays;

public class N06_RotateArrayByKPlaces {
//    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

//    Input: nums = [1,2,3,4,5,6,7], k = 3
//    Output: [5,6,7,1,2,3,4]

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(input, k);
    }

    private static void rotate(int[] nums, int k) {
        // If rotation is greater than size of array
        k = k % nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                // Printing rightmost kth elements
                System.out.print(nums[nums.length + i - k]
                        + " ");
            } else {
                // Prints array after 'k' elements
                System.out.print(nums[i - k]
                        + " ");
            }
        }
        System.out.println();
    }

    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k >= n

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);
        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Step 3: Reverse the remaining elements
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
