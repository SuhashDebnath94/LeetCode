package recursion;

import java.util.Arrays;

public class reverseArray {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};

        Arrays.stream(reverseArrayFunc(arr, 0, arr.length-1)).forEach(x-> System.out.println(x));
    }

    private static int[] reverseArrayFunc(int[] arr,int low ,int high) {

        if(high<=low){
            return arr;
        }
        else{
            int temp=arr[high];
            arr[high]=arr[low];
            arr[low]=temp;
            return reverseArrayFunc(arr, low+1, high-1);
        }
    }
}
