package bitManipulation;

import java.util.Arrays;

public class N14_FindRepeatingAndMissingNumber {
//    You are given a read-only array of N integers with values also in the range [1, N] both inclusive.
//    Each integer appears exactly once except A which appears twice and B which is missing.
//    The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

//    Input Format:  array[] = {3,1,2,5,3}
//
//    Result: {3,4)
//
//        Explanation: A = 3 , B = 4
//        Since 3 is appearing twice and 4 is missing

//    000 0
//    001  1
//    010  2
//    011  3
//    100   4
//    101  5
//    110  6
//    111  7

//    000 ^ 001 => 001 0^1
//    001^ 010  => 011 0^1^2
//    010 ^ 011 => 001 0^1^2^3
//    001 ^ 100 -> 101 0^1^2^4
//    101 ^ 101 => 000 0^1^2^3^5


//    3,1,2,5,3

//    000 ^ 011 = 011 0^3
//    011 ^ 100 = 111 0^3^1
//    111 ^ 010 = 101 0^3^1^2
//    101 ^ 101 = 000 0^3^1^2^5 (this element is not present)
//    000 ^ 011 = 011 0^3^1^2^5^3 (this element is present twice)

//    Let x and y be the desired output elements.
//
//    Calculate the XOR of all the array elements.
//
//    xor1 = arr[0]^arr[1]^arr[2]…..arr[n-1]
//
//    XOR the result with all numbers from 1 to n
//
//    xor1 = xor1^1^2^…..^n
//
//    xor1 will have the result as (x^y), as others would get canceled.
//    Since we are doing XOR, we know xor of 1 and 0, is only 1, so all the set bits in xor1, mean that the index bit is only set at x or y.

    public static void main(String[] args) {

        int[] arr={3, 1, 2, 5, 3};
        int[] res=findDuplicate(arr);
        System.out.println(" Duplicate item is : "+res[0]);
        System.out.println(" Missing item is : "+res[1]);

    }

    private static int[] findDuplicate(int[] arr) {
        int[] arrTemp=new int[arr.length];
        int[] res= new int[2];
        Arrays.fill(arrTemp, 0);
        for(int i=0;i<arr.length;i++){
            arrTemp[arr[i]-1]=arrTemp[i]+1;
        }
        for(int i=0;i<arrTemp.length;i++){
            if (arrTemp[i]!=1){
                if(arrTemp[i]>1){
                    res[0]=i+1;
                }
                else {
                    res[1]=i+1;
                }
            }
        }
        return res;
    }


}
