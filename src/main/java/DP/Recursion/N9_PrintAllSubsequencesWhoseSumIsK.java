package DP.Recursion;

import java.util.ArrayList;
import java.util.List;

public class N9_PrintAllSubsequencesWhoseSumIsK {
    /*
    For each index we have an option to either take or not take
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List arr2 = new ArrayList();
        printAllSubsequencesWithSumK(0, arr, arr2, 0, 3);
    }

    private static void printAllSubsequencesWithSumK(int i, int[] arr, List<Integer> arr2, int currentSum, int targetSum) {
        if (i == arr.length) {
            if (currentSum == targetSum)
                System.out.println(arr2);
            return;
        }
        arr2.add(arr[i]);
        printAllSubsequencesWithSumK(i + 1, arr, arr2, currentSum+arr[i], targetSum);
        arr2.remove(arr2.size() - 1);
        printAllSubsequencesWithSumK(i + 1, arr, arr2, currentSum, targetSum);
    }
}
