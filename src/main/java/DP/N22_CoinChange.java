package DP;

import java.util.Arrays;
import java.util.LinkedList;

public class N22_CoinChange {

//    We are given an array Arr with N distinct coins and a target. We have an infinite supply of each coin denomination. We need to find the number of ways we sum up the coin values to give us the target.
//
//    Each coin can be used any number of times.
    static long countWaysToMakeChangeUtil(int[] arr, int ind, int T, long[][] dp) {

        if (ind == 0) {
            if (T % arr[0] == 0)
                return 1;
            else
                return 0;
        }

        if (dp[ind][T] != -1)
            return dp[ind][T];

        long notTaken = countWaysToMakeChangeUtil(arr, ind - 1, T, dp);

        long taken = 0;
        if (arr[ind] <= T)
            taken = countWaysToMakeChangeUtil(arr, ind, T - arr[ind], dp);

        return dp[ind][T] = notTaken + taken;
    }


    static long countWaysToMakeChange(int[] arr, int n, int T) {

        long dp[][] = new long[n][T + 1];
        for (long row[] : dp)
            Arrays.fill(row, -1);
        return countWaysToMakeChangeUtil(arr, n - 1, T, dp);
    }

    public static void main(String args[]) {

        int arr[] = {1, 2, 3};
        int target = 4;

        int n = arr.length;

        System.out.println("The total number of ways is " + countWaysToMakeChangePrac(arr, n, target));
    }

    private static long countWaysToMakeChangePrac(int[] arr, int n, int target) {
        LinkedList<Integer> list=new LinkedList<>();
        return getWaysToMakeChangePrac(0, arr, n, list, target, 0);
    }

    private static int getWaysToMakeChangePrac(int i, int[] arr, int n, LinkedList<Integer> list, int target, int count) {
        if(i>=n){
            return count;
        }
        if(arr[i]>target){
            return count;
        }
        if(arr[i]==target){
            count++;
            System.out.println();
            list.stream().forEach(x -> System.out.print(" "+ x+" "));
            System.out.print(" "+ target+" ");
            System.out.println();
            return count;
        }

        list.add(arr[i]);
        target=target-arr[i];
        count=getWaysToMakeChangePrac(i, arr, n, list, target, count);
        list.removeFirstOccurrence(arr[i]);
        target=target+arr[i];
        count=getWaysToMakeChangePrac(i+1, arr, n, list, target, count);

        return count;
    }

}
