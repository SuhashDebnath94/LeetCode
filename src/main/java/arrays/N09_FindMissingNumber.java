package arrays;

public class N09_FindMissingNumber {
    /**
     * In an array of 1 to n-1 one number is missing, find that number
     */
    public static void main(String[] args) {
        Integer[] arr={1,2,4,6,5,7,8};
        System.out.println(findMissingNumber(arr));
    }

    private static int findMissingNumber(Integer[] arr) {

//        find sum of 1 to n
        int n=arr.length+1;
        int l=arr.length;
        Integer sum= (n*(n+1))/2;

        int sumOfAllNumbersOfArray=0;
        for(int i=0;i<l;i++) {
            sumOfAllNumbersOfArray+=arr[i];
        }

        return sum-sumOfAllNumbersOfArray;

    }
}
