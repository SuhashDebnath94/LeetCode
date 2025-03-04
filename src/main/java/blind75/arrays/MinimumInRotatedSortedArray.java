package blind75.arrays;

public class MinimumInRotatedSortedArray {
//    Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
//    For example, the array nums[] = [0,1,2,4,5,6,7] might become:
//
//          [4,5,6,7,0,1,2] if it was rotated 4 times.
//          [0,1,2,4,5,6,7] if it was rotated 7 times.
//    Given the sorted rotated array nums of unique elements, return the minimum element of this array.

//    Input: nums = [3,4,5,1,2]
//      Output: 1

    public static void main(String args[]) {
        int nums[] = {4, 5, 1, 2, 3};
        int minVal = calculateMinVal(nums);
        System.out.println("Minimum Value is " + minVal);
    }

    private static int calculateMinVal(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        } else {
            int[] newNum = new int[nums.length - 1];
//            or use a stack and each time this happens do a pop and pass
            for (int i = 1; i < nums.length; i++) {
                newNum[i - 1] = nums[i];
            }
            return calculateMinVal(newNum);
        }
    }

    static int calculateMinValOpt(int arr[]) {
        int min_ele = arr[0];

        // Traversing over array to
        // find minimum element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min_ele) {
                min_ele = arr[i];
            }
        }

        return min_ele;
    }

    private static int findMinValOpt(int[] nums) {
        // If the list has just one element then return that element.
        if (nums.length == 1) {
            return nums[0];
        }

        // initializing left and right pointers.
        int left = 0, right = nums.length - 1;

        // if the last element is greater than the first element then there is no
        // rotation.
        // e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array.
        // Hence the smallest element is first element. A[0]
        if (nums[right] > nums[0]) {
            return nums[0];
        }

        // Binary search way
        while (right >= left) {
            // Find the mid element
            int mid = left + (right - left) / 2;

            // if the mid element is greater than its next element then mid+1 element is the
            // smallest
            // This point would be the point of change. From higher to lower value.
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // if the mid element is lesser than its previous element then mid element is
            // the smallest
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            // if the mid elements value is greater than the 0th element this means
            // the least value is still somewhere to the right as we are still dealing with
            // elements
            // greater than nums[0]
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                // if nums[0] is greater than the mid value then this means the smallest value
                // is somewhere to
                // the left
                right = mid - 1;
            }
        }
        return Integer.MAX_VALUE;

    }
}
