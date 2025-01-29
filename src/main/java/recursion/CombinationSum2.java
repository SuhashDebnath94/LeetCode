package recursion;

import java.util.LinkedList;

public class CombinationSum2 {
    //    Find all the combinations that could lead to a target sum in an array
//    an element can be used 1 time.
    public static void main(String[] args) {
        int[] arr={1,2,6,7};
        coinChange(arr, 8);
    }

    private static void coinChange(int[] arr, int target) {
        LinkedList<Integer> list=new LinkedList<>();
        int n=arr.length;
        getCombinations(0, n,  arr, target, list);
    }
    private static void getCombinations(int i, int n, int[] arr, int target, LinkedList<Integer> list) {
        if(i>=n){
            return;
        }
        if(arr[i]>target){
            return;
        }
        if(arr[i]==target){
            System.out.println();
            list.stream().forEach(x -> System.out.print(" "+ x+" "));
            System.out.print(" "+ target+" ");
            System.out.println();
            return;
        }

        //pick
        list.add(arr[i]);
        target=target-arr[i];
        getCombinations(i+1, n,  arr, target, list);
//        not pick
        target=target+arr[i];
        list.removeFirstOccurrence(arr[i]);
        getCombinations(i+1, n,  arr, target, list);
    }
}
