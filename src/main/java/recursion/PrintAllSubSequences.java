package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubSequences {
//    input 3 1 2
//    3
//    1
//    2
//    3 1
//    1 2
//    3 2 (not contiguous)
//    3 1 2

//    3 2 1 is not a subsequence since they are not in order

//    for each index we have 2 options take it or leave it
//    leave take take gives 1 2
//    leave leave take gives 2 and so on

//    base case:
//        if index>array length then print array and return
//      list.add(arr[i])
//      f(ind+1, list) the recursion will go and come back
//    once it comes back list.remove(a[i])
//    f(ind+1, list)

//    Steps
//      1) you call function with index 0 and empty list, the index is 0 and array is empty
//        2) now your list will contain the first element 3 (list.add(arr[i]))
//        3) We Call the function f(ind+1, list), which is f(1, [3]);
//      4) now your list will contain the first element 3,1 (list.add(arr[i]))
//        5) We Call the function f(ind+1, list), which is f(2, [3,1]);
//    6) now your list will contain the first element 3,1, 2 (list.add(arr[i]))
//    7) We Call the function f(ind+1, list), which is f(3, [3,1, 2]);
//    8) In this case base case will return since index = arr.length (3, 1, 2) will be printed
//    9) now it will return
//      10) now we have picked the last index now we have an option to not pick the last index (list.remove(a[i]))
//        11) now it goes as f(3, [3,1]) and hence will print 3,1 in base case
//    12) it will come back and remove 1
//    13) now it goes as f(3, [3]) and hence will print 3 in base case

    public static void main(String[] args) {
        int[] arr={3,2,1};
        int n= arr.length;
        List<Integer> ds= new ArrayList<>();
        printSubsequences(0,ds, arr, n);
    }

    private static void printSubsequences(int i, List<Integer> ds, int[] arr, int n) {
        if(i==n){
            ds.stream().forEach(x -> System.out.print (" "+x+", "));
            System.out.println(" ");
            return;
        }
        ds.add(arr[i]);
        printSubsequences(i+1, ds, arr, n);
        ds.remove(arr[i]);
        printSubsequences(i+1, ds, arr, n);
    }


}


