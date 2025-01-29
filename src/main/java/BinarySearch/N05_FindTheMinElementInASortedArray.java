package BinarySearch;

public class N05_FindTheMinElementInASortedArray {
    /**
     * Given a sorted array which is Rotated by n times find the minimum element in it.
     *
     */

    public static void main(String[] args) {
        int n = 3;
        int[] arr = {9, 10, 11, 1, 2, 4, 5};
        System.out.println(findMinimum(n, arr));
    }

    private static int findMinimum(int n, int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            int mid = (low + high) / 2;
            if (arr[mid] < arr[high]) high = mid; //if mid is less than high we are eleminating everything on the right of mid
            else low = mid + 1; //else we are eleminating everything on the left of mid including mid
        }

        return arr[low];
    }
}
