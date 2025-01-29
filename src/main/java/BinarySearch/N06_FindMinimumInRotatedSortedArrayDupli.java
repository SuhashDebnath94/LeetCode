package BinarySearch;

public class N06_FindMinimumInRotatedSortedArrayDupli {
    /**
     * Given a sorted array which is Rotated by n times find the minimum element in it. The array might contain duplicates
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
            if (arr[mid] < arr[high]) high = mid;
            else if(arr[mid]>arr[high]) low = mid + 1;
            else high--; //if the high is equals to mid then we know last element is not the answer and hence we remove that.
        }

        return arr[low];
    }
}
