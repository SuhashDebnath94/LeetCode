package DP.Recursion;

import java.util.ArrayList;
import java.util.List;

public class N10_PrintOneSubsequencesWhoseSumIsK {
    /*
    For each index we have an option to either take or not take
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List arr2 = new ArrayList();
        printAllSubsequencesWithSumK(0, arr, arr2, 0, 3);
    }

    private static boolean printAllSubsequencesWithSumK(int i, int[] arr, List<Integer> arr2, int currentSum, int targetSum) {
        if (i == arr.length) {
            if (currentSum == targetSum) {
                System.out.println(arr2);
                return true;
            }
            return false;
        }
        arr2.add(arr[i]);
        if(printAllSubsequencesWithSumK(i + 1, arr, arr2, currentSum+arr[i], targetSum)) return true;
        arr2.remove(arr2.size() - 1);
        if (printAllSubsequencesWithSumK(i + 1, arr, arr2, currentSum, targetSum)) return true;
        return false;
    }
}
