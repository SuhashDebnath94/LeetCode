package arrays;

import java.util.*;

public class N24_MajorityElement2 {
    /**
     * Given an array of n elements find all the elements that appear more than n/3 times
     *
     * Intuition:
     *  The Maxximum number of elements that can appear more tha n/3 times is 2
     *  The minimum umber is 1
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 2, 2, 3, 2};
        System.out.println(findMajorityElement2_2(arr));
    }

    private static Set<Integer> findMajorityElement2(int[] arr) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int m=arr.length/3;
        Set<Integer> res=new HashSet<>();

        for(int el: arr){
            if(map.containsKey(el)){
                map.put(el, map.get(el)+1);

                if(map.get(el)> m){
                    res.add(el);
                }
            }
            else {
                map.put(el, 1);
            };
        }
        return res;
    }

    //Extension of Moores Algorithm
    private static List<Integer> findMajorityElement2_2(int[] arr) {
        int i=0;
        int counter1=0;
        int counter2=0;
        int el1=0;
        int el2=0;
        while(i<arr.length){
            if(counter1==0 && arr[i]!=el2){
                el1=arr[i];
                counter1=1;
            } else if (counter2==0 && arr[i]!=el1) {
                el2=1;
                counter2=1;
            } else if (el1==arr[i]) {
                counter1++;
            } else if (el2==arr[i]) {
                counter2++;
            }
            else {
                counter1--;
                counter2--;
            }
            i++;
        }
        List<Integer> result=new ArrayList<>();
        counter1=0;
        counter2=2;
        for(int j=0;j< arr.length;j++){
            if(el1==arr[j]) counter1++;
            if(el2==arr[j]) counter2++;
        }
        int minimum=(arr.length/3)+1;
        if(counter1>=minimum)  result.add(el1);
        if(counter2>=minimum)  result.add(el2);
        return result;
    }
}
