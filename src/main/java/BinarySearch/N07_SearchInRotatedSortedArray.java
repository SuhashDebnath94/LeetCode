package BinarySearch;

public class N07_SearchInRotatedSortedArray {
    /**
     * Given a sorted array which is Rotated by n times find the element n in it.If not present return -1
     */

    public static void main(String[] args) {
        int n = 9;
        int[] arr = {9, 10, 11, 1, 2, 4, 5};
        System.out.println(search(n, arr));
    }

    private static int search(int n, int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == n) return mid;

            //either left is sorted or right is sorted
            if (arr[low] < arr[mid]) {
//                check if element is present here
                if (n >= arr[low] && n <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {
                if (n >= arr[mid] && n <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;
    }
}
