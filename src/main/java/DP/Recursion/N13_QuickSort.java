package DP.Recursion;
import java.util.Arrays;

public class N13_QuickSort {
    // Method to perform quicksort on the array
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(array, low, high);

            // Recursively sort elements before and after partition
            quickSort(array, low, pivotIndex - 1);  // Sort left half
            quickSort(array, pivotIndex + 1, high); // Sort right half
        }
    }

    // Partition method to place the pivot element in the correct position
    public static int partition(int[] array, int low, int high) {
        // Select the pivot element (last element in this case)
        int pivot = array[high];
        int i = low - 1; // Index for the smaller element

        // Traverse through the array and rearrange elements
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++; // Increment index for smaller element
                swap(array, i, j); // Swap current element with the element at i
            }
        }

        // Place the pivot element in its correct position
        swap(array, i + 1, high);

        // Return the index of the pivot element
        return i + 1;
    }

    // Helper method to swap two elements in the array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};

        System.out.println("Original array:");
        System.out.println(Arrays.toString(array));

        // Perform quicksort on the entire array
        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(array));
    }
}
