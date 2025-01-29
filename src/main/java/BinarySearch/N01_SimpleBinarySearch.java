package BinarySearch;

public class N01_SimpleBinarySearch {
    /**
     * Search for the first occurrence of a number n in a sorted array.
     */

    public static void main(String[] args) {
        int n = 1;
        int[] arr = {1, 2, 3, 3, 7, 8, 9, 9, 9, 11};
        System.out.println(findIndexOf(n, arr));
        System.out.println(findIndexOfRec(n, arr, 0, arr.length - 1));
    }

    private static int findIndexOf(int n, int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            if (arr[mid] == n) return mid;
            if (n > arr[mid]) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    private static int findIndexOfRec(int n, int[] arr, int low, int high) {
        if (low > high) return -1;
        int mid = low + high / 2;
        if (arr[mid] == n) return mid;
        if (n > arr[mid]) return findIndexOfRec(n, arr, mid + 1, high);
        return findIndexOfRec(n, arr, low, mid - 1);
    }
}
