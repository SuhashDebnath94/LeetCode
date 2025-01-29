package DP.Recursion;

import java.util.ArrayList;
import java.util.List;

public class N11_CountNumberOfSubsequencesWhoseSumIsK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List arr2 = new ArrayList();
        System.out.println(countAllSubsequencesWithSumK(0, arr, arr2, 0, 3));
    }

    private static int countAllSubsequencesWithSumK(int i, int[] arr, List arr2,  int currentSum, int targetSum) {
        if(i==arr.length){
            if(targetSum==currentSum) return 1;
            else return 0;
        }
        arr2.add(arr[i]);
        int take= (countAllSubsequencesWithSumK(i + 1, arr, arr2, currentSum+arr[i], targetSum));
        arr2.remove(arr2.size()-1);
        int notTake= (countAllSubsequencesWithSumK(i + 1, arr, arr2, currentSum, targetSum));
        return take+notTake;
    }
}
