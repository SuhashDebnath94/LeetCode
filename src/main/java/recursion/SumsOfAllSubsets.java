package recursion;

import java.util.LinkedList;

public class SumsOfAllSubsets {

    public static void main(String[] args) {
        int[] arr={3, 1, 2};
        sumSubsets(arr);
    }

    private static void sumSubsets(int[] arr) {
        LinkedList<Integer> list=new LinkedList<>();
        int sum=0;
        int n=arr.length;
        getSumOfSubSets(0, n, arr, list, 0);

        System.out.println();
        list.stream().forEach(x -> System.out.print(" "+ x+" "));
    }

    private static LinkedList<Integer> getSumOfSubSets(int i, int n, int[] arr, LinkedList<Integer> list, int sum) {
        if(i==n){
            list.add(sum);
            return list;
        }
        //take
        sum+=arr[i];
        list=getSumOfSubSets(i+1, n, arr, list, sum);
        sum-=arr[i];
        list=getSumOfSubSets(i+1, n, arr, list, sum);

        return list;
    }
}
