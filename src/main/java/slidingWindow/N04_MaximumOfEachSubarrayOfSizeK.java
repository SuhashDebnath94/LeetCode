package slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class N04_MaximumOfEachSubarrayOfSizeK {

    public static void main(String[] args) {
        int[] arr={12, -1, -7, 8, -15, 30, 16, 28};
        int windowSize=3;
        System.out.println(maxArrayOfallSubArrays(arr, windowSize));

    }

    private static List<Integer> maxArrayOfallSubArrays(int[] arr, int windowSize) {
        int i=0;
        int j=0;
        List<Integer> result=new ArrayList<>();

        while(j<arr.length){
            if((j-i)+1<windowSize){
                j++;
            }
            else {
                int max=Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    max=Math.max(max,arr[k]);
                }
                result.add(max);
                i++;
                j++;
            }
        }

        return result;
    }
}
