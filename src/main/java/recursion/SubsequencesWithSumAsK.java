package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesWithSumAsK {
    public static void main(String[] args) {

        int[] arr={1,2,3};
        int n= arr.length;
        List<Integer> ds= new ArrayList<>();

        printSubsequences(0, n, arr, ds,4);
    }

    private static void printSubsequences(int i, int n, int[] arr, List<Integer> ds, int sum) {

        if(i==n){
            if(ds.stream().reduce(0,(a,b)-> a+b)==sum){
                System.out.println();
                ds.stream().forEach(x -> System.out.print(" "+ x+" "));
                System.out.println();
            }
            return;
        }
        ds.add(arr[i]);
        printSubsequences(i+1, n, arr, ds, sum);
        ds.removeIf(x -> x.equals(arr[i]));
        printSubsequences(i+1, n, arr, ds, sum);

    }
}
