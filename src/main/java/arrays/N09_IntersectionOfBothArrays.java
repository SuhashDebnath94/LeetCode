package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N09_IntersectionOfBothArrays {
    /*
    Given two integer arrays nums1 and nums2, return an array of their intersection.
    Each element in the result must be unique and you may return the result in any order.
     */
    public static void main(String[] args) {
        Integer[] arr1={1,2,3,4,5,6};
        Integer[] arr2={4,5,6,7,8};
        System.out.println(findIntersection(arr1, arr2));
    }

    private static List<Integer> findIntersection(Integer[] arr1, Integer[] arr2) {
        List<Integer> list1= Arrays.asList(arr1);
        List<Integer> list2= Arrays.asList(arr2);

        List<Integer> result= new ArrayList<>();

        int i=0;
        int j=0;

        while(i<arr1.length && j<arr2.length){
            if(list1.get(i)==list2.get(j)){
                result.add(list1.get(i));
                i++;
                j++;
            }
            else {
                i++;
            }
        }
        return result;
    }

}
