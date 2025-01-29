package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutations {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        printAllPermutations(arr);
    }

    private static void printAllPermutations(int[] arr) {
        ArrayList<Integer> list=new ArrayList<>();
        getAllPermutations(arr, arr.length, 0, list);
    }

    private static void getAllPermutations(int[] arr, int n, int i, ArrayList<Integer> list) {
        if(i>n){
            System.out.println(list);
            return;
        }



    }
}
