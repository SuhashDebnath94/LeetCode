package arrays;

public class N14_sortArray012 {
    /**
     * Given an array A[] consisting of only 0s, 1s, and 2s.
     * The task is to write a function that sorts the given array.
     * The functions should put all 0s first, then all 1s and all 2s in last.
     * Given an array A[] consisting of only 0s, 1s, and 2s.
     * The task is to write a function that sorts the given array.
     * The functions should put all 0s first, then all 1s and all 2s in last.
     */

    static void printArray(int arr[], int arr_size)
    {
        int i;
        for (i = 0; i < arr_size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    /*Driver function to check for above functions*/
    public static void main(String[] args)
    {
        int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        int arr_size = arr.length;
        sort012(arr, arr_size);
        printArray(arr, arr_size);
    }

    //Dutch national flag algorithm
    private static void sort012(int[] arr, int n) {
        int high=n-1;
        int low=0;
        int mid=0;
        int temp=0;

        while(mid<=high) {
            switch (arr[mid]) {
                case 0:
                    temp = arr[mid];
                    arr[mid] = arr[low];
                    arr[low] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                    break;
            }
        }
    }

    /**
     * Another solution could be
     * Step 1:
     *  Count the number of 0s, 1s, and 2s
     * Step 2:
     *  Manually override the elements of the array according to the count.
     *
     * T(C)-> O(2N)
     */
}
