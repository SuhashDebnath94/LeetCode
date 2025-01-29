package BinarySearch;

public class N11_LowerBound {
    /*
    You are given an array 'arr' sorted in non-decreasing order and a number 'x'. You must return the index of the lower bound of 'x'.



Note:
1. For a sorted array 'arr', 'lower_bound' of a number 'x' is defined as the smallest index 'idx' such that the value 'arr[idx]' is not less than 'x'.If all numbers are smaller than 'x', then 'n' should be the 'lower_bound' of 'x', where 'n' is the size of array.

2. Try to do this in O(log(n)).


Example:
Input: ‘arr’ = [1, 2, 2, 3] and 'x' = 0

Output: 0

Explanation: Index '0' is the smallest index such that 'arr[0]' is not less than 'x'.
     */

    /*
    This is also solution to ceil in an array (largest number in array greater than = x)
    This is also very similar to upper bound and floor
     */
    public static void main(String[] args) {
        int k = 8;
        int[] arr = {1, 2, 3, 3, 7, 8, 9, 9, 9, 11};
        System.out.println(lowerBound(k, arr, 0, arr.length - 1));
    }

    private static int lowerBound(int k, int[] arr, int low, int high) {
        int lowerbound = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= k) {
                lowerbound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lowerbound;

    }


}
