package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N19_leadersInAnArray {
    /**
     * Given an array return an array containing all the leader elements
     * An element is a leader when none of the elements on the right is greater than that element
     */
    public static void main(String[] args) {
        Integer[] arr={5,6,7,3,4,2,1};
        System.out.println(findLeaders(arr));
    }

    private static List<Integer> findLeaders(Integer[] arr) {
        if(arr.length!=0){
            List<Integer> result=new ArrayList<>();
            int max=Integer.MIN_VALUE;
            for (int i = arr.length-1;i>=0;i--){
                if(arr[i]>max){
                    result.add(arr[i]);
                    max=arr[i];
                }
            }
            return result;
        }
        return Arrays.asList(arr);
    }
}
