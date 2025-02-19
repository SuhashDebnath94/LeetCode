package arrays;

import java.util.*;

public class N26_MajorityElement2 {
    /**
     * Given an array of n elements find all the elements that appear more than n/3 times
     *
     * Intuition:
     *  The Maxximum number of elements that can appear more tha n/3 times is 2
     *  The minimum umber is 1
     */

    /*
     we track at most two potential candidates and count their frequencies.

    Why two candidates?
    A number can only appear more than n/3 times if there are at most two such numbers.
    Think of n = 9: If an element appears more than 3 times, there can’t be more than two such elements.
    Steps:
    Find two potential candidates for majority elements.
    Verify if they truly appear more than n/3 times.
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 2, 2, 3, 2};
        System.out.println(findMajorityElement2_2(arr));
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
        counter2=0;
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
