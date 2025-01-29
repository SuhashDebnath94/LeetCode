package BinarySearch;

public class N10_SplitArrayLargestSum {
    /**
     * Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
     * Return the minimized largest sum of the split.
     * A subarray is a contiguous part of the array.
     *
     * Example 1:
     *
     * Input: nums = [7,2,5,10,8], k = 2
     * Output: 18
     * Explanation: There are four ways to split nums into two subarrays.
     *
     *      7       `2+5+10+8   max is 25
     *      7+2     `5+10+8     max is 23
     *      7+2+5   `10+8       max is 18
     *      7+2+5+8 `10         max is 22
     *
     *
     * The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
     *
     *
     * Soln:
     *  What can be the least size of sub array?
     *      1
     *  What can be the maximum sum of least size subarray?
     *      10
     *
     *  So we can say the lowest answer we can get is 10, since if they ask for n sub arrays the largest sum will be:
     *      10
     *
     *  So if lets say they need 1 subarray, we will have the maximum sum as sum of all elements that is:
     *      32
     *
     *  So we have been asked for 2 subarrays, so the maximum sum will lie somewhere between:
     *      low and high is 10 and 32
     *
     *  So suppose we say mid is 10+32/2 = 21 and the sum of sub array cant be greater than 21, can we divide into 2 subarrays?
     *      7+2+5   10+8
     *      So now we will bring down high to mid-1
     *      so mid is 10+20/2 =15
     *      can we form 2 sub arrays with minimum as 15?
     *          7+2+5=14
     *          10+8=18     so no
     *         So we move low to mid+1=16
     *     Now low=16, high=20 mid=18
     *      Can we divide keeping 18 as minimum?
     *          7+2+5   10+8
     *          yes so we move high to 18
     *      high=18, low=16, mid=17
     *      can we divide keeping 17 as minimum?
     *          no.
     *          So we move low to mid+1
     *      Now low=high
     *          so we return mid
     *
     *
     *
     *
     *
     */

    public static void main(String[] args) {
        int k = 2;
        int[] arr = {7,2,5,10,8};
        System.out.println(getSmallestDivisor(k, arr));
    }

    private static int getSmallestDivisor(int k, int[] arr) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for(int i=0;i<arr.length;i++){
            low=Math.max(low,arr[i]);
        }
        for(int i=0;i<arr.length;i++) high+=arr[i];

        while (low <= high) {

            int mid = (low + high) / 2;
            if (canWeDivideintoKSubbArrays(arr, k , mid)) {
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean canWeDivideintoKSubbArrays(int[] arr, int k, int mid) {
        int count=1;
        int sum= 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>mid) return false;

            if(sum+arr[i]>mid){
                count++;
                sum=arr[i];
            }
            else {
                sum+=arr[i];
            }
        }
        return count<=k;
    }

}
