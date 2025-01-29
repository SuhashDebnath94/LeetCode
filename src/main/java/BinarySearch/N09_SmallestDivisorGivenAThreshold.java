package BinarySearch;

import java.util.Arrays;

public class N09_SmallestDivisorGivenAThreshold {
    /**
     * Binary Search on Answers:
     * We do an operation on index 1
     * We do the same operation on index 2
     * We do the same operation on index 3
     * We do the same operation on index 4
     * <p>
     * So suppose we have a question like find the minimum divisor less than theshold with an array
     * Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
     * Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
     * The test cases are generated so that there will be an answer.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,5,9], threshold = 6
     * Output: 5
     * Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
     * If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).
     * <p>
     * We divide by 1 we get 1, 2, 4, 9
     * we divide by 2 we get 1, 1, 3, 5
     * We divide by 3 we get 1, 1, 2, 3
     * We divide by 4 we get 1, 1, 2, 3
     * We divide by 5 we get 1, 1, 1, 2
     * <p>
     * So we see as we are increasing divisor, the answer is decreasing.
     * We get a number of answers.
     * We do binary search on the answers.
     * <p>
     * In this we see the lowest divisor is 1 and the highest divisor is the max of the array.
     * <p>
     * Binary search is about elimination.
     * So we put high as arr.max and low as 1
     * So we first do the division process by mid(high+low/2)
     * <p>
     * Suppose arr.max is 9
     * mid = 1+9/2=5
     * <p>
     * We divide by 5 and get summation. 1+1+1+2 =5
     * We see summation 5 is less than threshold
     * <p>
     * now 5 can be a possible answer *****
     * now move high to 5
     * <p>
     * Now do the same thing
     * mid=5+1/2=3
     * <p>
     * We divide by 3 and get summation= 1+1+2+3=7 which is greater than divisor
     * so we move low to mid+1
     * <p>
     * Now low is 4 and high is 5
     * mid=4+5/2=4
     * We divide by 4 and get summation= 1+1+2+3=7 which is greater than divisor
     * so we move low to mid+1
     * <p>
     * so now low =5 and high =5
     * we can return low since high=low
     */

    public static void main(String[] args) {
        int threshold = 17;
        int[] arr = {1, 2, 5, 9};
        System.out.println(getSmallestDivisor(threshold,9, arr));
    }

    private static int getSmallestDivisor(int threshold, int n, int[] arr) {
        int low = 0;
        int high = n;

        while (low < high) {

            int mid = (low + high) / 2;
            if (findSumAfterDivision(arr, n , mid) < threshold) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int findSumAfterDivision(int[] arr, int n, int mid) {
        int sum = 0;
        int i = 0;
        while (i < arr.length) {
            sum += Math.ceil(Double.valueOf(arr[i]) / Double.valueOf(mid));
            i++;
        }
        return sum;
    }
}
