package arrays;

import java.util.HashMap;

public class N14_MajorityElementInAnArray {
    /**
     * Given an array, return the majority element ie the element that occurs more than n/2 times
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 2, 2, 3, 2};
        System.out.println(findMajorityElement2(arr));
    }

    private static int findMajorityElement(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int majority = arr.length / 2;

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (Integer elem : map.keySet()) {
            if (map.get(elem) > majority) {
                return elem;
            }
        }
        return -1;
    }

    //Moores voting algorithm
    private static int findMajorityElement2(int[] arr) {
        int i=0;
        int count=0;
        int result=0;
        while(i<arr.length){
            if(count==0){
                result=arr[i];
            }
            if(arr[i]==result){
                count++;
            }
            else {
                count--;
            }
            i++;
        }
        if(count!=0) return result;
        return -1;
    }
}
