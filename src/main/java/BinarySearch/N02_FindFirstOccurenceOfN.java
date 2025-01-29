package BinarySearch;

public class N02_FindFirstOccurenceOfN {
    /**
     * Given an array of duplicates, find the first occurence of n
     * n=3
     * arr={1,2,2, 3,3, 3, 5,6,8,8,9}
     * <p>
     * ans: 3
     */

    public static void main(String[] args) {
        int n = 3;
        int[] arr = {1, 2, 2, 3, 3, 3, 5, 6, 8, 8, 9};
        System.out.println(findFirstOccurenceOf(n, arr));
    }

    private static int findFirstOccurenceOf(int n, int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {

            int mid = (low + high) / 2;
            if (arr[mid] == n) {
                ans = mid;
                high = mid - 1;
            } else if (n > arr[mid]) low = mid + 1;
            else high = mid - 1;
        }

        return ans;
    }
}
