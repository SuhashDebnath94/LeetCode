package BinarySearch;

public class N03_GivenXFindTheCountOfOccurences {
    /**
     * Given a number x in an array find the number of occurences of x in the array
     */

    public static void main(String[] args) {
        int n = 7;
        int[] arr = {1, 2, 2, 3, 3, 3, 3, 5, 6, 8, 8, 9};
        System.out.println(findCountOfOccurences(n, arr));
    }

    private static int findCountOfOccurences(int n, int[] arr) {
        int fo=findFirstOccurenceOf(n, arr);
        if(fo==-1) return 0;
        else return lastOccurenceOf(n, arr)-findFirstOccurenceOf(n, arr)+1;
    }

    private static int lastOccurenceOf(int n, int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {

            int mid = (low + high) / 2;
            if (arr[mid] == n) {
                ans = mid;
                low= mid+1;
            } else if (n > arr[mid]) low = mid + 1;
            else high = mid - 1;
        }

        return ans;
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
