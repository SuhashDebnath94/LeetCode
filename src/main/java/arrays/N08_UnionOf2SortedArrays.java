package arrays;

import java.util.*;

public class N08_UnionOf2SortedArrays {
    /**
     * Get the union of 2 arrays
     * Union contains all the unique elements in both the arrays.
     */
    public static void main(String[] args) {
        Integer[] arr1={1,2,3,4,5,6};
        Integer[] arr2={4,5,6,7,8};
        System.out.println(findUnion2(arr1, arr2));
    }

    private static Set<Integer> findUnion(int[] arr1, int[] arr2) {
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<arr1.length;i++) set.add(arr1[i]);
        for (int i=0;i<arr2.length;i++) set.add(arr2[i]);

        return set;
    }

//    or

    // not done yet.
    private static List<Integer> findUnion2(Integer[] arr1, Integer[] arr2){

        List<Integer> list1= Arrays.asList(arr1);
        List<Integer> list2= Arrays.asList(arr2);

        List<Integer> result= new ArrayList<>();

        int i=0;
        int j=0;

        while(i<arr1.length && j<arr2.length){
            if(list1.get(i)<list2.get(j)){
                result.add(list1.get(i));
                i++;
            } else if (list2.get(j)<list1.get(i)) {
                result.add(list2.get(j));
                j++;
            }
            else {
                result.add(list1.get(i));
                i++;
                j++;
            }
        }

        for(;i<arr1.length;i++){
            result.add(list1.get(i));
        }
        for(;j<arr2.length;j++){
            result.add(list2.get(j));
        }
        return result;
    }
}
