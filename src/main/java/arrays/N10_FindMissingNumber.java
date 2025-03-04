package arrays;

public class N10_FindMissingNumber {
    /**
     * In an array of 1 to n-1 one number is missing, find that number
     */
    public static void main(String[] args) {
        Integer[] arr={1,2,4,6,5,0,7,8};
        System.out.println(findMissingNumber(arr));
        System.out.println(missingNumber(arr));
    }

    private static int findMissingNumber(Integer[] arr) {

//        find sum of 1 to n
        int n=arr.length;
        Integer sum= (n*(n+1))/2;

        int sumOfAllNumbersOfArray=0;
        for(int i=0;i<n;i++) {
            sumOfAllNumbersOfArray+=arr[i];
        }

        return sum-sumOfAllNumbersOfArray;

    }
    public static int missingNumber(Integer[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
