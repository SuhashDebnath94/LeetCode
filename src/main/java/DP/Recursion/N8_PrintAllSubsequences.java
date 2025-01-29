package DP.Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class N8_PrintAllSubsequences {
    /*
    For each index we have an option to either take or not take
     */
    public static void main(String[] args) {
        int[] arr= {1, 2, 3};
        List arr2= new ArrayList();
        printAllSubsequences(0, arr, arr2);
    }

    private static void printAllSubsequences(int i, int[] arr, List<Integer> arr2) {
        if(i==arr.length){
            System.out.println(arr2);
            return;
        }
        arr2.add(arr[i]);
        printAllSubsequences(i+1, arr, arr2);
        arr2.remove(arr2.size()-1);
        printAllSubsequences(i+1, arr, arr2);
    }
}
